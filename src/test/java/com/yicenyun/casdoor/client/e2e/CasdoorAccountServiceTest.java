package com.yicenyun.casdoor.client.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yicenyun.casdoor.client.CasdoorClient;
import com.yicenyun.casdoor.client.entity.CasdoorOrganization;
import com.yicenyun.casdoor.client.entity.CasdoorUser;
import com.yicenyun.casdoor.client.response.CasdoorActionResponse;
import com.yicenyun.casdoor.client.response.CasdoorResponse;
import com.yicenyun.casdoor.client.service.CasdoorAccountService;
import com.yicenyun.casdoor.client.support.CasdoorClientProvider;

public class CasdoorAccountServiceTest {
    private CasdoorClient client = CasdoorClientProvider.get();
    private CasdoorAccountService subject;

    @BeforeEach
    public void setUp() {
        subject = client.createService(CasdoorAccountService.class);
    }

    @Test
    public void setPassword() throws Exception {
        CasdoorActionResponse response = subject
                .setPassword("built-in", "admin", "12345678", "12345678")
                .execute().body();
        assertEquals("ok", response.getStatus());
    }

    @Test
    public void getAccount() throws IOException {
        /* When */
        CasdoorResponse<CasdoorUser, CasdoorOrganization> response = subject
                .getAccount(token())
                .execute().body();
        /* Then */
        assertEquals("ok", response.getStatus());
        assertNotNull(response.getData());
        assertNotNull(response.getData2());
    }

    private String token() {
        return "eyJhbGciOiJSUzI1NiIsImtpZCI6ImNlcnQtYnVpbHQtaW4iLCJ0eXAiOiJKV1QifQ." +
                        "eyJvd25lciI6InlpY2VueXVuIiwibmFtZSI6InljYWRtaW4iLCJjcmVhdGVkVGltZSI6IjIwMjMtMDctMjFUMDE6MDA6MDErM"
                        +
                        "Dg6MDAiLCJ1cGRhdGVkVGltZSI6IiIsImlkIjoiYmE3Mjk0N2QtZWEyYS00NjVhLWE0NGEtZGFlZTdhN2M2MWRkIiwidHlwZS"
                        +
                        "I6Im5vcm1hbC11c2VyIiwicGFzc3dvcmQiOiIiLCJwYXNzd29yZFNhbHQiOiIiLCJkaXNwbGF5TmFtZSI6IuW8iOWykeeuoee"
                        +
                        "QhuWRmCIsImZpcnN0TmFtZSI6IiIsImxhc3ROYW1lIjoiIiwiYXZhdGFyIjoiaHR0cDovL2xvY2FsaG9zdDo4MDAwL2ltYWdl"
                        +
                        "cy9kZWZhdWx0LWF2YXRhci5zdmciLCJwZXJtYW5lbnRBdmF0YXIiOiIiLCJlbWFpbCI6ImFAZXhhbXBsZS5jb20iLCJlbWFpb"
                        +
                        "FZlcmlmaWVkIjpmYWxzZSwicGhvbmUiOiIxMzYxMjM0NTY3OCIsImxvY2F0aW9uIjoi5YyX5LqsIiwiYWRkcmVzcyI6W10sIm"
                        +
                        "FmZmlsaWF0aW9uIjoi5byI5bKR5LqRIiwidGl0bGUiOiLlt6XnqIvluIgiLCJpZENhcmRUeXBlIjoiIiwiaWRDYXJkIjoiIiw"
                        +
                        "iaG9tZXBhZ2UiOiJodHRwOi8vYS5jb20iLCJiaW8iOiIiLCJyZWdpb24iOiJDTiIsImxhbmd1YWdlIjoiIiwiZ2VuZGVyIjoi"
                        +
                        "IiwiYmlydGhkYXkiOiIiLCJlZHVjYXRpb24iOiIiLCJzY29yZSI6MjAwMCwia2FybWEiOjAsInJhbmtpbmciOjEsImlzRGVmY"
                        +
                        "XVsdEF2YXRhciI6ZmFsc2UsImlzT25saW5lIjpmYWxzZSwiaXNBZG1pbiI6dHJ1ZSwiaXNHbG9iYWxBZG1pbiI6ZmFsc2UsIm"
                        +
                        "lzRm9yYmlkZGVuIjpmYWxzZSwiaXNEZWxldGVkIjpmYWxzZSwic2lnbnVwQXBwbGljYXRpb24iOiJqYWd1YXItYXBwY2VudGV"
                        +
                        "yIiwiaGFzaCI6IiIsInByZUhhc2giOiIiLCJjcmVhdGVkSXAiOiIiLCJsYXN0U2lnbmluVGltZSI6IiIsImxhc3RTaWduaW5J"
                        +
                        "cCI6IiIsImxkYXAiOiIiLCJwcm9wZXJ0aWVzIjp7fSwicm9sZXMiOltdLCJwZXJtaXNzaW9ucyI6W10sImxhc3RTaWduaW5Xc"
                        +
                        "m9uZ1RpbWUiOiIiLCJzaWduaW5Xcm9uZ1RpbWVzIjowLCJ0b2tlblR5cGUiOiJhY2Nlc3MtdG9rZW4iLCJzY29wZSI6Im9wZW"
                        +
                        "5pZCBwcm9maWxlIGVtYWlsIGFkZHJlc3MgcGhvbmUiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjcwMDEiLCJzdWIiOiJiYTc"
                        +
                        "yOTQ3ZC1lYTJhLTQ2NWEtYTQ0YS1kYWVlN2E3YzYxZGQiLCJhdWQiOlsiNjM2OGExMDQxYjQ2ZTVkMTU2YWIiXSwiZXhwIjox"
                        +
                        "NjkwNTE2NzQxLCJuYmYiOjE2ODk5MTE5NDEsImlhdCI6MTY4OTkxMTk0MSwianRpIjoiYWRtaW4vNjliMGM0NjUtZGU1MC00N"
                        +
                        "GUwLWI4NzItMWQxODE4YWNjYTZhIn0.wcXfd-CgMzfSPX0Q8Pl9e1ncS_dQ19I0etNeRAZatXhBGLK6m1scolMEIR2bDoPUfT"
                        +
                        "4c5dgpFJhF4WOwdFMZhedtAqQMn1G6UE7Jneq9afXDiVXjNpLPHu3-SJnseBI1OCTkAkXpKs7qXa-Crj_aRXI03Q0EjuKozrV"
                        +
                        "nV4y1Pnmt30puu_JN215v0vzOMcLAF6V8ek1XfICoPS8o0XWavkLP0T9OP9k-1dErrzMWHu71gbZKpqFwIa8suaz3lFLM2_MY"
                        +
                        "-RvH59h2XrtiMtA35ECvnUVfUzzU5NAlp1Spa4o9QPZGko6zaNvbvNLQp4X5-vYcRJiX5p7rqqxZ-0Di5UpfPhwMlQYtST-Wl"
                        +
                        "iiRGDVno_WS5SvlSSyPGT8vVbtxNTbkRMOy_D6BhI0fIISCSOEd0gSRgtbg6RajStsc60WeoScl8JUiJoNQ2w2YV45wWtuKKc"
                        +
                        "MHbG4Ugu9HdnxFh7Rd9MDbrT2HEEbxz_PmuE9zSjisPGLyBCVPv-QmRzEjBRj0QgnRRaxzTCaYP76K6YXv2nHRYQtI598WM4U"
                        +
                        "AjQ-D82GmQNTQvUTMsBUxI5ZF0OgI3QxLgNav3OSwNSZ0Zf1-U49W5EtIt0BuuIQo_y0Y_KP-edO-M9NSdc9HfNS1n36PX0iG"
                        +
                        "Q6OfkKwRSb_UEFh0WH0rINA0IFGOOQAF1YY";
    }
}
