package com.enigma.wms_api.Model.ModelResponse;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PagingResponse {
    private Integer count;
    private Integer totalPage;
    private Integer page;
    private Integer size;
}
