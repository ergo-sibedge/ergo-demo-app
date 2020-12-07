package com.sibedge.ergo.shared.transport;

import java.util.List;

import lombok.Value;

@Value(staticConstructor = "of")
public class ErrorData {
    List<String> errors;
}
