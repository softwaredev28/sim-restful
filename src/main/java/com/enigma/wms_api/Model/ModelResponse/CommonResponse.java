package com.enigma.wms_api.Model.ModelResponse;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CommonResponse<T>{
    private T data;
    private String errors;
    private PagingResponse paging;
}
