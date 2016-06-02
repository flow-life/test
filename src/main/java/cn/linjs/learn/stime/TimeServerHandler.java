package cn.linjs.learn.stime;

import io.netty.channel.ChannelHandlerAdapter;

/**
 * Created by linjs on 2015/8/21.
 */
public class TimeServerHandler extends ChannelHandlerAdapter {
//
//    private int counter;
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        ctx.close();
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
////        ByteBuf buf = (ByteBuf) msg;
////        byte[] req = new byte[buf.readableBytes()];
////        buf.readBytes(req);
////        String body = new String(req,"UTF-8").substring(0,req.length - System.getProperty("line.separator").length());
//        String body = (String)msg;
//        System.out.println("The time server receive order : " + body + " ; the counter is : " + ++counter);
//
//        String currentTime = "query time order".equalsIgnoreCase(body)?
//                new Date(System.currentTimeMillis()).toString():"BAD ORDER";
//        currentTime = currentTime + System.getProperty("line.separator");
//        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
//        ctx.writeAndFlush(resp);
//    }
//
//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.flush();
//    }
}
