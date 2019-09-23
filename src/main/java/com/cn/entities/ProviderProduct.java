package com.cn.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderProduct {
    private Integer id;
    private Integer providerId;
    private Integer level;

    @Override
    public String toString() {
        return "ProviderProduct{" +
                "id=" + id +
                ", providerId=" + providerId +
                ", level=" + level +
                '}';
    }
}
