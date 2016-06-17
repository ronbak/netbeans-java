/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package davclient;

import com.github.sardine.*;
import com.github.sardine.impl.SardineException;
import com.github.sardine.impl.SardineImpl;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.BasicUserPrincipal;
import org.apache.http.auth.Credentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.*;
import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author bar
 * call like: java -jar davClient.jar username password https://owncloud.com/owncloud/remote.php/webdav/
 * returns:
[/owncloud/remote.php/webdav/, /owncloud/remote.php/webdav/Documents/, /owncloud/remote.php/webdav/New Text Document.txt, /owncloud/remote.php/webdav/katie/]

 */
public class DavClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Require parameters: username password davurl");
        }
        try {
            List<DavResource> list = testBasicAuth(args[0], args[1], args[2]);
            System.out.println(list);
        } catch (Exception e) {
            System.err.println("Ehm error handle " + e);
        }
    }

    public static List<DavResource> testBasicAuth(String username, String password, String davurl) throws Exception {
        Sardine sardine = SardineFactory.begin(username, password);
        URI url = URI.create(davurl);
        List<DavResource> resources = sardine.list(url.toString());
        return resources;
    }
}
