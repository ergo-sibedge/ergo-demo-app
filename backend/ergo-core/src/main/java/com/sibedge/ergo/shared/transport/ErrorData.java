package com.sibedge.ergo.shared.transport;

import java.util.List;

import lombok.Value;

/**
 * Describes the standard error message
 * for transport purposes.
 */
@Value(staticConstructor = "of")
public class ErrorData {
    List<String> errors;
}
