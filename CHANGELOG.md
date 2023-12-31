# CHANGELOG

## v1.3.0 (2023-12-31)

### ⚠ BREAKING CHANGES

* use QueryCommand to build a query

### Features

* add login and logout services ([ec51cde](https://github.com/towerhe/casdoor-client/commit/ec51cdeec3a6ff8eb50c36ee7bb2c63887128d4c))
* can set the query param key by the value of @CasdoorId ([d2d281e](https://github.com/towerhe/casdoor-client/commit/d2d281e340573819e07d6dcbdddc3a031f98e507))
* create a service for casbin apis ([db2e791](https://github.com/towerhe/casdoor-client/commit/db2e791dbbc778682467456f97bfc4f05a76c0a2))
* implements application management apis ([8d94d92](https://github.com/towerhe/casdoor-client/commit/8d94d923a99cd8901bfd672bc1479f3d3de278e5))
* implements group management apis ([6468143](https://github.com/towerhe/casdoor-client/commit/64681439e64f07173355014aac58ab4a16326366))
* implements organization management apis ([0e7975e](https://github.com/towerhe/casdoor-client/commit/0e7975eea94af0ebf4dfb581c38e1a5df0fa6143))
* **Login:** provide support to autoSignin ([06301fd](https://github.com/towerhe/casdoor-client/commit/06301fd584d8b63b9ffd23a88601d56d4249bad7))
* **Logout:** provide more overloads of logout service method ([5a19406](https://github.com/towerhe/casdoor-client/commit/5a19406931057e921846d3e835a43dba0d0cb3be))

### Bug Fixes

* entity name in toString() ([0b48577](https://github.com/towerhe/casdoor-client/commit/0b48577abfc04255950923710481acf720a0d1dd))
* parsing user from JWT token ([4a2c9bc](https://github.com/towerhe/casdoor-client/commit/4a2c9bc591cde41a82111cd62fdc6940f29adc04))
* token parsing error ([cd541a8](https://github.com/towerhe/casdoor-client/commit/cd541a8f273a3f4eec1bf5b7d4a5e70fd4a0b1d8))

### Code Refactoring

* use QueryCommand to build a query ([27d83a4](https://github.com/towerhe/casdoor-client/commit/27d83a41c49644a08c2f1f08f6b05068a4410701))
