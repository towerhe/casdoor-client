// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.yicenyun.casdoor.client.exception;

public class CasdoorAuthException extends CasdoorException {
    public CasdoorAuthException() {
        super();
    }

    public CasdoorAuthException(String message, Throwable cause) {
        super(message, cause);
    }

    public CasdoorAuthException(String message) {
        super(message);
    }

    public CasdoorAuthException(Throwable cause) {
        super(cause);
    }
}
