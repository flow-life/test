package jasper.test;

import javassist.NotFoundException;
import javassist.bytecode.AttributeInfo;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pine on 2016/11/28.
 */
public class JspClassReaderDemo {
    public static void main(String[] args) throws IOException, NotFoundException {
        String[]files = {
                "E:\\WorkTools\\tomcat\\apache-tomcat-8.0.26_2\\webapps\\ROOT2\\tt\\abcd\\WEB_002dINF\\views\\ace\\po_jsp.class",
//                "E:\\WorkTools\\tomcat\\apache-tomcat-8.0.26_2\\webapps\\ROOT2\\tt\\abcd\\formError_jsp.class",
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
//            String str = new String(bytes);
//            System.out.println(str);
            buildSmap(bytes);
        }
    }

    /**
     * jsr-45
     * @param bytes
     */
    public static void buildSmap(byte[] bytes){
        String str = new String(bytes);
        int sF = str.indexOf("*F");
        int sL = str.indexOf("*L");
        int sE = str.indexOf("*E");
        String fileStr = str.substring(sF + 2, sL);
        String lineStr = str.substring(sL + 2, sE);
        Map fileMap = getFileMap(fileStr);
//        Map fileExp = fileExp(lineStr);
        int[] fp = filePos(lineStr,171);
        if(fp != null){
            System.out.println("fullFileName:" + fileMap.get(fp[0]));
            System.out.println("lineNum:" + fp[1]);
        }
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
     * build expression data map.
     * key:fileId,value:expression list
     * @param fileStr
     * @return
     */
    public static Map fileExp(String fileStr){
        Map fileExpMap = new HashMap();
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
            LineInfo lineInfo = new LineInfo(iStart,oStart,iCount,oIncre);
            List lineList =  (ArrayList)fileExpMap.get(cFileId);
            if(lineList == null){
                lineList = new ArrayList();
            }
            lineList.add(lineInfo);
            fileExpMap.put(cFileId,lineList);
        }
        return fileExpMap;
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

    private static class JLineToS {
        /**
         * target file(java file) start num
         */
        private int startLine;
        /**
         * target file(java file) end num
         */
        private int endLine;
        /**
         * source Line num.mapping from startLine through endLine
         */
        private int sLine;

        public JLineToS(int startLine, int endLine, int sLine) {
            this.startLine = startLine;
            this.endLine = endLine;
            this.sLine = sLine;
        }

        public int getStartLine() {
            return startLine;
        }

        public int getEndLine() {
            return endLine;
        }

        public int getsLine() {
            return sLine;
        }
    }

    /**
     * store Java file number mapping to input file
     * @param info
     * @return
     */
    public static List<JLineToS> calJLine(LineInfo info) {
        List<JLineToS> jtss = new ArrayList();
        int ic = info.getiC();
        int o = info.getoS();
        int is = info.getiS();
        int oi = info.getoI();
        for (int i = 0; i < ic; i++) {
            int iis = is + i;
            int oS = o + i;
            int oE = o + (i + 1) * oi - 1;
            jtss.add(new JLineToS(oS,oE,iis));
        }
        return jtss;
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
