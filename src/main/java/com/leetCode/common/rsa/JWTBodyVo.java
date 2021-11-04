package com.leetCode.common.rsa;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class JWTBodyVo {
    private String jti;
    private String iss;
    private Long iat;
    private String sub;
    private Long exp;
}
