package cn.linjs.learn.stime;

/**
 * Created by linjs on 2015/8/23.
 */
public class TimeClient {
//    public void connect(int port,String host) throws Exception{
//        //配置客户端NIO线程组
//        EventLoopGroup group = new NioEventLoopGroup();
//
//        try {
//            Bootstrap b = new Bootstrap();
//            b.group(group).channel(NioSocketChannel.class)
//                    .option(ChannelOption.TCP_NODELAY, true)
//                    .handler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel socketChannel) throws Exception {
//                            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
//                            socketChannel.pipeline().addLast(new StringDecoder());
//                            socketChannel.pipeline().addLast(new TimeClientHandler());
//                        }
//                    });
//            //发起异步链接操作
//            ChannelFuture f = b.connect(host,port).sync();
//
//            //等待客户端链路关闭
//            f.channel().closeFuture().sync();
//        } finally {
//            group.shutdownGracefully();
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        int port = 8080;
//        new TimeClient().connect(port,"127.0.0.1");
//    }
}
