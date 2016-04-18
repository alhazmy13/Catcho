package net.alhazmy13.catcho.library;

/**
 * Created by Alhazmy13 on 4/16/16.
 * Catcho
 */



import java.security.AccessController;
import java.security.Provider;

/**
 * The type Jsse provider.
 */
final class JSSEProvider extends Provider {

    /**
     * Instantiates a new Jsse provider.
     */
    public JSSEProvider() {
        super("HarmonyJSSE", 1.0, "Harmony JSSE Provider");
        AccessController.doPrivileged(new java.security.PrivilegedAction<Void>() {
            public Void run() {
                put("SSLContext.TLS",
                        "org.apache.harmony.xnet.provider.jsse.SSLContextImpl");
                put("Alg.Alias.SSLContext.TLSv1", "TLS");
                put("KeyManagerFactory.X509",
                        "org.apache.harmony.xnet.provider.jsse.KeyManagerFactoryImpl");
                put("TrustManagerFactory.X509",
                        "org.apache.harmony.xnet.provider.jsse.TrustManagerFactoryImpl");
                return null;
            }
        });
    }
}