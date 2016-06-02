package cn.linjs.learn.stime;

/**
 * 使用Netty创建的Time Server
 * Created by linjs on 2015/8/21.
 */
public class TimeServer {
//
//    public void bind(int port) throws Exception {
//        //配置服务端的NIO线程组
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//
//        try {
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
//                    .option(ChannelOption.SO_BACKLOG, 1024)
//                    .childHandler(new ChildChannelHandler());
//            //绑定端口，同步等待成功
//            ChannelFuture f = b.bind(port).sync();
//
//            //等待服务端监听端口关闭
//            f.channel().closeFuture().sync();
//        } finally {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//    }
//
//    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
//
//        @Override
//        protected void initChannel(SocketChannel socketChannel) throws Exception {
//            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
//            socketChannel.pipeline().addLast(new StringDecoder());
//            socketChannel.pipeline().addLast(new TimeServerHandler());
//        }
//    }
//
//    public static void main(String[] args) throws Exception{
//        int port = 8080;
//        if(args != null && args.length > 0){
//            try {
//                port = Integer.parseInt(args[0]);
//            } catch (NumberFormatException e) {
//                //采用默认值
//            }
//        }
//        new TimeServer().bind(port);
//    }
}
