package com.amazonaws.serverless.transfer.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Transfer {

    private String fromAccount;
    private String toAccount;
    private String amount;
    private String transferDate;
}
