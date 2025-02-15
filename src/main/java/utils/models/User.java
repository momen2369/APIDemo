package utils.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Builder.Default
    private String name = "unknown";
    @Builder.Default
    private String job = "unemployed";
    @Builder.Default
    private int age = 18;
    private int id;
    private String createdAt;
    private String updatedAt;
}
