package cn.linjs.learn.stime;

import io.netty.channel.ChannelHandlerAdapter;

/**
 * Created by linjs on 2015/8/23.
 */
public class TimeClientHandler extends ChannelHandlerAdapter {
//
////    private final ByteBuf firstMessage;
//    private int counter;
//
//    private byte[] req;
//
//    public TimeClientHandler() {
//         req = ("query time order" + System.getProperty("line.separator")).getBytes();
////        firstMessage = Unpooled.buffer(req.length);
////        firstMessage.writeBytes(req);
//    }
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
////        ctx.writeAndFlush(firstMessage);
//        ByteBuf message = null;
//        for(int i = 0; i < 100; i++){
//            message = Unpooled.buffer(req.length);
//            message.writeBytes(req);
//            ctx.writeAndFlush(message);
//        }
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
////        ByteBuf buf = (ByteBuf) msg;
////        byte[] req = new byte[buf.readableBytes()];
////        buf.readBytes(req);
////        String body = new String(req,"UTF-8");
//        String body = (String)msg;
//        System.out.println("Now is : " + body + " ; the counter is :" + ++counter);
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        //释放资源
//        ctx.close();
//    }
}
