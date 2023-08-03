# casdoor-client

`casdoor-client` is a new java client for casdoor.

## Install

```xml
<dependency>
  <groupId>com.yicenyun.casdoor</groupId>
  <artifactId>casdoor-client</artifactId>
  <version>{version}</version>
</dependency>
```

## Usage

1. create a client:

    ```java
    CasdoorClient client = new CasdoorClient.Builder()
                                            .endpoint("http://localhost:8000")
                                            .baseUri("api")
                                            .clientId("32429b048ffbfc93cb99")
                                            .clientSecret("4e191daebd5e4616139a2aa7ea1f1d86d48e40ec")
                                            .certificate("your application's public key")
                                            .organizationName("built-in")
                                            .applicationName("app-built-in")
                                            .log(Level.BODY)
                                            .build();
    ```

2. create services:

    ```java
    // Create an instance of CasdoorAuthService
    CasdoorAuthService authService = client.createService(CasdoorAuthService.class);

    // Create an instance of CasdoorOrganizationService
    CasdoorOrganizationService orgService = client.createService(CasdoorOrganizationService.class);
    ```

3. call service methods:

    ```java
    CasdoorResponse<List<CasdoorOrganization>, Integer> response = subject.getOrganizations().execute().body();
    List<CasdoorOrganization> organizations = response.getData();
    Integer orgCount = response.getData2();
    ```
