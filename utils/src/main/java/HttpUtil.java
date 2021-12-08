import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: HttpUtil
 * @Description: TODO
 * @Author: wugongzi
 * @Date: 2019/12/19 15:45
 * @Version: 1.0
 */
public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    private final static int CONNECT_TIMEOUT = 5000;
    private final static int CONNECTION_REQUEST_TIMEOUT = 2000;
    private final static int SOCKET_TIMEOUT = 15000;

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public static String doGet(String url) {
        logger.info("doGet参数：url：({})", url);
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(CONNECT_TIMEOUT).setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT).build();
            httpGet.setConfig(requestConfig);
            httpGet.setHeader("Accept", "application/json");
            httpGet.setHeader("Content-Type", "application/json");
            response = httpclient.execute(httpGet);

            int state = response.getStatusLine().getStatusCode();
            if (state == HttpStatus.SC_OK) {
                //读取服务器返回过来的json字符串数据
                return EntityUtils.toString(response.getEntity());
            } else {
                //throw new ConsumerException("doGet请求返回：state：" + state + "，url：(" + url + ")");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.info(e.getMessage(), e);
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.info(e.getMessage(), e);
            }
        }
        return null;

    }

    /**
     * get请求
     *
     * @param url
     * @param parameters
     * @return
     */
    public static String doGet(String url, Map<String, String> parameters) {
        logger.info("doGet参数：url：({}),parameters：{}", url, parameters);
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (!CollectionUtils.isEmpty(parameters)) {
                for (Map.Entry<String, String> entry : parameters.entrySet()) {
                    uriBuilder.addParameter(entry.getKey(), entry.getValue());
                }
            }
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(CONNECT_TIMEOUT).setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT).build();
            httpGet.setConfig(requestConfig);
            httpGet.setHeader("Accept", "application/json");
            httpGet.setHeader("Content-Type", "application/json");
            response = httpclient.execute(httpGet);

            int state = response.getStatusLine().getStatusCode();
            if (state == HttpStatus.SC_OK) {
                //读取服务器返回过来的json字符串数据
                return EntityUtils.toString(response.getEntity());
            } else {
                //throw new ConsumerException("doGet请求返回：state：" + state + "，url：(" + url + ")" + "，parameters：" + parameters);
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return null;
    }


    /**
     * post请求
     *
     * @param url
     * @param parameters
     * @return
     */
    public static String doPost(String url, Map<String, String> parameters) {
        logger.info("doPost参数：url：({}),parameters：{}", url, parameters);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            if (!CollectionUtils.isEmpty(parameters)) {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>();
                NameValuePair pair = null;
                for (Map.Entry<String, String> entry : parameters.entrySet()) {
                    pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
                    pairs.add(pair);
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs);
                httpPost.setEntity(entity);
            }
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(CONNECT_TIMEOUT).setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT).build();
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-Type", "application/json");
            response = httpclient.execute(httpPost);

            int state = response.getStatusLine().getStatusCode();
            if (state == HttpStatus.SC_OK) {
                //读取服务器返回过来的json字符串数据
                return EntityUtils.toString(response.getEntity());
            } else {
                //throw new ConsumerException("doPost请求返回：state：" + state + "，url：(" + url + ")" + "，parameters：" + parameters);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.info(e.getMessage(), e);
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.info(e.getMessage(), e);
            }
        }
        return null;

    }

    /**
     * post请求（用于请求json格式的参数）
     *
     * @param url
     * @param parameters
     * @return
     */
    public static String doPost(String url, String parameters) {
        logger.info("doPost参数：url：({}),parameters：{}", url, parameters);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            if (!StringUtils.isEmpty(parameters)) {
                StringEntity entity = new StringEntity(parameters, StandardCharsets.UTF_8);
                httpPost.setEntity(entity);
            }
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(CONNECT_TIMEOUT).setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT).build();
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-Type", "application/json");
            response = httpclient.execute(httpPost);

            int state = response.getStatusLine().getStatusCode();
            if (state == HttpStatus.SC_OK) {
                //读取服务器返回过来的json字符串数据
                return EntityUtils.toString(response.getEntity());
            } else {
                //throw new ConsumerException("doPost请求返回：state：" + state + "，url：(" + url + ")" + "，parameters：" + parameters);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.info(e.getMessage(), e);
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.info(e.getMessage(), e);
            }
        }
        return null;

    }

}
