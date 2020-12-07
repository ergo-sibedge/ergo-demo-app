package com.sibedge.ergo.shared.transport;

import java.util.List;

import lombok.Data;

@Data(staticConstructor = "of")
public class ListData<T> {
    private final List<T> content;
    private final long total;
}
