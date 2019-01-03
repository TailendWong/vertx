package pers.selton.vertx.datasearch;

import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.*;
import io.vertx.core.net.NetSocket;
import io.vertx.core.net.SocketAddress;
import io.vertx.ext.web.RoutingContext;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.security.cert.X509Certificate;
import java.util.Objects;

public class Router2ResteasyRequestAdapter implements HttpServerRequest {

    private HttpServerRequest request;
    private RoutingContext context;

    public Router2ResteasyRequestAdapter(RoutingContext context) {
        this.request = context.request();
        this.context = context;
    }

    @Override
    public HttpServerRequest exceptionHandler(Handler<Throwable> handler) {
        request.exceptionHandler(handler);
        return this;
    }

    @Override
    public HttpServerRequest handler(Handler<Buffer> handler) {
        Buffer body = context.getBody();
        if (Objects.nonNull(body)) {
            handler.handle(body);
        }
        return this;
    }

    @Override
    public HttpServerRequest pause() {
        request.pause();
        return this;
    }

    @Override
    public HttpServerRequest resume() {
        request.resume();
        return this;
    }

    @Override
    public HttpServerRequest endHandler(Handler<Void> handler) {
        handler.handle(null);
        return this;
    }

    @Override
    public HttpVersion version() {
        return request.version();
    }

    @Override
    public HttpMethod method() {
        return request.method();
    }

    @Override
    public String rawMethod() {
        return request.rawMethod();
    }

    @Override
    public boolean isSSL() {
        return request.isSSL();
    }

    @Override
    public String scheme() {
        return request.scheme();
    }

    @Override
    public String uri() {
        return request.uri();
    }

    @Override
    public String path() {
        return request.path();
    }

    @Override
    public String query() {
        return request.query();
    }

    @Override
    public String host() {
        return request.host();
    }

    @Override
    public HttpServerResponse response() {
        return request.response();
    }

    @Override
    public MultiMap headers() {
        return request.headers();
    }

    @Override
    public String getHeader(String s) {
        return request.getHeader(s);
    }

    @Override
    public String getHeader(CharSequence charSequence) {
        return request.getHeader(charSequence);
    }

    @Override
    public MultiMap params() {
        return request.params();
    }

    @Override
    public String getParam(String s) {
        return request.getParam(s);
    }

    @Override
    public SocketAddress remoteAddress() {
        return request.remoteAddress();
    }

    @Override
    public SocketAddress localAddress() {
        return request.localAddress();
    }

    @Override
    public SSLSession sslSession() {
        return request.sslSession();
    }

    @Override
    public X509Certificate[] peerCertificateChain() throws SSLPeerUnverifiedException {
        return new X509Certificate[0];
    }

    @Override
    public String absoluteURI() {
        return request.absoluteURI();
    }

    @Override
    public NetSocket netSocket() {
        return request.netSocket();
    }

    @Override
    public HttpServerRequest setExpectMultipart(boolean b) {
        return request.setExpectMultipart(b);
    }

    @Override
    public boolean isExpectMultipart() {
        return request.isExpectMultipart();
    }

    @Override
    public HttpServerRequest uploadHandler(Handler<HttpServerFileUpload> handler) {
        return request.uploadHandler(handler);
    }

    @Override
    public MultiMap formAttributes() {
        return request.formAttributes();
    }

    @Override
    public String getFormAttribute(String s) {
        return request.getFormAttribute(s);
    }

    @Override
    public ServerWebSocket upgrade() {
        return request.upgrade();
    }

    @Override
    public boolean isEnded() {
        return request.isEnded();
    }

    @Override
    public HttpServerRequest customFrameHandler(Handler<HttpFrame> handler) {
        return request.customFrameHandler(handler);
    }

    @Override
    public HttpConnection connection() {
        return request.connection();
    }
}
