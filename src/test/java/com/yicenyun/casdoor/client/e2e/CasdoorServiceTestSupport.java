package com.yicenyun.casdoor.client.e2e;

import com.yicenyun.casdoor.client.config.CasdoorConfig;

public abstract class CasdoorServiceTestSupport {
    protected CasdoorConfig casdoorConfig = new CasdoorConfig(
            "http://localhost:8000",
            "d119d4d1601b11da1460",
            "1cc6ed68d9cfd992473238e390e0c9737fb6c2fd",
            "-----BEGIN CERTIFICATE-----\n" + //
                    "MIIE8zCCAtugAwIBAgIDAeJAMA0GCSqGSIb3DQEBCwUAMDMxETAPBgNVBAoTCHlp\n" + //
                    "Y2VueXVuMR4wHAYDVQQDExV5aWNlbnl1bi1kZWZhdWx0LWNlcnQwHhcNMjMxMjA2\n" + //
                    "MDYyODA2WhcNNDMxMjA2MDYyODA2WjAzMREwDwYDVQQKEwh5aWNlbnl1bjEeMBwG\n" + //
                    "A1UEAxMVeWljZW55dW4tZGVmYXVsdC1jZXJ0MIICIjANBgkqhkiG9w0BAQEFAAOC\n" + //
                    "Ag8AMIICCgKCAgEAoULTZCbVrAg6ylQete/Q8fgInADf7zgE188YCA2gwiZ1mqTd\n" + //
                    "36o56/BJU8NGZdCJ1v+Llieh/rgvtztX9np0yORmHJGeDQnBg2Otuclffnxk7qFr\n" + //
                    "aIjhiJTuxSxINDbaFtocDUq+aszJmHtrVXuLDhHJMm+Bf51Osbx5cmigWQTBjthP\n" + //
                    "BXXknMQzeKzd0hfqY5RVHP4jwAVoEkkT2jOu3QeEeMnB3BBpUxt44ZrnFffuPqNL\n" + //
                    "/eI92k0UH3NHD2beZlxECsE6O9aCNloN0UU8jlnXkbJ63R9G8lZWRJmMY5IfbLZP\n" + //
                    "Ret/uXkPXq03nAzpFx9GTTjPks5EmsilfvvnKhvHlUSlPd+tY9eeOD3JkYmMNzy4\n" + //
                    "t6xsMWGvsdZkPqAACSzHsi8GFk0gE6C0UeMaZPwajhj0WGqAm2rsiUFUblAY3tlM\n" + //
                    "0FotmsfciRm87VvIdlyy69lhGe/jE9II2r0ridC06B7HcT8qmVoO6OIzT3ne053U\n" + //
                    "GlJukwl9VKefQ5YGtpwzuI59jjzdvDCknnBV0sjADrnucqnyyepihx4ZBEi0zoZO\n" + //
                    "26KJnkbis57ZPeYcuvFZz+836XMX/zViPVld8RBC4evDliFaXXrBlXf/thJMWp+9\n" + //
                    "rPMRZWdJcYXuZoLKD/WfKB5yMPWA9vA0AU87ycM0hbmfO2JyJVll0ptg0GsCAwEA\n" + //
                    "AaMQMA4wDAYDVR0TAQH/BAIwADANBgkqhkiG9w0BAQsFAAOCAgEAHw2X9vZl4JcR\n" + //
                    "E+5nmLCe+/wU01o4iuYtyc7ozCeE/eyTK0jyWrhBFQHLd9Zfg9K6I7uKI1LAcB0L\n" + //
                    "TNugQV7XIvXSRurQ+5FRyfnjjR3my85bvZJ6lBPgDbnUnPoklxThfS7XPwOeX8Ow\n" + //
                    "4ubKpV7YmBIazmXC+TqTUI2+4VQ+2lLNV2CB4BFZTnlTzNRyStIoTCYxwl2AFW8q\n" + //
                    "8GizYDYs2vc9lZYfEHtxRaLDIkyNBsiv98f4CRU68ZPN0uUqln9Y8tIKd/9Tyr8g\n" + //
                    "NFYKXqxncohMxxNSTUsEPyVT1fG1pH2a+yVb5cBpbD5isI0CEYmq+KZy9t6MiNgD\n" + //
                    "OLP43NgAiblZ2B6N5y5vVSUFFuII7kocksfJKQvSGLrYcEj3NB2+ahHptgsuDVXi\n" + //
                    "9DOP1R81nyDUFGAsUUvUZu0vpzXVYkiKw5o0a695GApfAHUrcGDFPboZg5nANOz+\n" + //
                    "WoF0NT3q83Hnlkz2UwmhyuQr+HNJvocYf6Mio8Yxm2hSvGA9MV+Lk7TEYxuSsmh/\n" + //
                    "5WgspmGIiBfzpseMH/Kd3tD1ASEBGvNc7FPmq89XIs8Co0uWs7t1kDnm6ZVSnANs\n" + //
                    "zAiMLFDU1aXe19ix0iHgOlr8lWgy9W4ViB2r84LIxNbCP8OlGIux+qhvtr3p9jNd\n" + //
                    "kY1+G3CmegS19RqGwcbf6VNrwmBjeAQ=\n" + //
                    "-----END CERTIFICATE-----\n" + //
                    "",
            "yicenyun",
            "yicenyun-site");
}
