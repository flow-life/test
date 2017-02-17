package jasper.test;

import javassist.NotFoundException;
import javassist.bytecode.AttributeInfo;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pine on 2016/11/28.
 */
public class JspClassReader {
    public static void main(String[] args) throws IOException, NotFoundException {
        String[]files = {
                "E:\\WorkTools\\tomcat\\apache-tomcat-8.0.26_2\\webapps\\ROOT2\\tt\\abcd\\WEB_002dINF\\views\\ace\\po_jsp.class"
        };

        for(int k = 0; k < files.length; k++){
            String file = files[k];
            System.out.println("Class : " + file);
            ClassFile classFile = new ClassFile(new DataInputStream(new FileInputStream(file)));
            AttributeInfo attributeInfo = classFile.getAttribute("SourceDebugExtension");
            if(attributeInfo == null){
                continue;
            }
            ConstPool cp = attributeInfo.getConstPool();
            System.out.println("attribute name :" + attributeInfo.getName() + "]\n\n");
            byte[]bytes = attributeInfo.get();
            System.out.println(getMsgByNum(bytes, 122));
        }
    }

    /**
     * jsr-45
     * @param bytes
     * @param javaNum
     * @return String[2]. 0 :fullFilename 1:sourceNum
     */
    public static Object[] getMsgByNum(byte[] bytes,int javaNum){
        String str = new String(bytes);
        int sF = str.indexOf("*F");
        int sL = str.indexOf("*L");
        int sE = str.indexOf("*E");
        String fileStr = str.substring(sF + 2, sL);
        String lineStr = str.substring(sL + 2, sE);
        Map fileMap = getFileMap(fileStr);
        int[] fp = filePos(lineStr,javaNum);
        if(fp != null){
            return new Object[]{fileMap.get(fp[0]),fp[1]};
        }
        return null;
    }

    /**
     * build file mapped data for map from jasper SMAP.
     * key:fileId(int),value:fullFileName(string)
     * @param fileStr
     * @return
     */
    public static Map getFileMap(String fileStr){
        Map fMap = new HashMap();
        String[] fs = fileStr.split("[+]");
        for(String f : fs){
            String[] lf = f.split("\n");
            if(lf.length == 2){
                int seq = Integer.parseInt(lf[0].split(" ")[1]);//byte 20(hex)
                String fullFileName = lf[1];
                fMap.put(seq,fullFileName);
            }
        }
        return fMap;
    }

    /**
     * @param fileStr
     * @return [0,1] 0:fileId 1:source file numer
     */
    public static int[] filePos(String fileStr,int javaNum){
        //current file id
        int cFileId = 0;
        String[] exps = fileStr.split("\n");
        for(String expLine : exps){
            if(expLine.indexOf(":") == -1){
                continue;
            }
            String[] expAry = expLine.split(":");
            String inputStr = expAry[0];
            String outputStr = expAry[1];
            String[] inputAry = inputStr.split(",");
            int iStart;
            int iCount = 1;
            if(inputAry.length > 1){
                iCount = Integer.parseInt(inputAry[1]);
                String[] iiPre = inputAry[0].split("#");
                iStart = Integer.parseInt(iiPre[0]);
                if(iiPre.length > 1){
                    cFileId = Integer.parseInt(iiPre[1]);
                }
            }else{
                iStart = Integer.parseInt(inputAry[0]);
            }
            String[] outputAry = outputStr.split(",");
            int oStart = Integer.parseInt(outputAry[0]);
            int oIncre = 0;
            if(outputAry.length > 1){
                oIncre = Integer.parseInt(outputAry[1]);
            }
            LineInfo lineInfo = new LineInfo(iStart,oStart,iCount - 1,oIncre);
            int result = calInputNum(javaNum,lineInfo);
            if(result != -1){
                return new int[]{cFileId,result};
            }
        }
        return null;
    }

    private static class LineInfo {
        /**
         * input file(Jsp file) start line
         */
        private int iS;
        /**
         * output file(java file) start line
         */
        private int oS;
        /**
         * input file count
         */
        private int iC = 0;
        /**
         * output file increment,default is zero
         */
        private int oI = 0;

        public LineInfo(int iS, int oS, int iC, int oI) {
            this.iS = iS;
            this.oS = oS;
            this.iC = iC;
            this.oI = oI;
        }

        public int getiS() {
            return iS;
        }

        public int getoS() {
            return oS;
        }

        public int getiC() {
            return iC;
        }

        public int getoI() {
            return oI;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("lI{");
            sb.append("iS=").append(iS);
            sb.append(", oS=").append(oS);
            sb.append(", iC=").append(iC);
            sb.append(", oI=").append(oI);
            sb.append('}');
            return sb.toString();
        }
    }


    /**
     * judge javaNum is in current express,through lineInfo
     * @param javaNum
     * @param lineInfo
     * @return -1 : not exist,else source line
     */
    public static int calInputNum(int javaNum,LineInfo lineInfo){
        if(lineInfo == null){
            return -1;
        }
        int oStart = lineInfo.getoS();
        if(javaNum < oStart){
            return -1;
        }
        int iStart = lineInfo.getiS();
        if(javaNum == oStart){
            return iStart;
        }
        int iCount = lineInfo.getiC();
        int oIncre = lineInfo.getoI();
        int max = oStart + (iCount+1) * oIncre - 1;
        if(javaNum > max){
            return -1;
        }
        if(oIncre == 0){
            return iStart;
        }
        int temp = ((javaNum + 1) - oStart);
        int _id = 0;
        if(iCount > 0){
            if(temp % iCount == 0){
                _id = temp / iCount;
            }else{
                _id = temp / iCount + 1;
            }
        }

        return iStart + _id;
    }
}
