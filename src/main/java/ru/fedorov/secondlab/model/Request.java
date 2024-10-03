package ru.fedorov.secondlab.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Request {

    @NotBlank(message = "UID не может быть пустым")
    @Size(max= 32)
    private String uid;

    @NotBlank
    @Size(max= 32)
    private String operationUid;

    private String systemName;
    @NotBlank
    private String systemTime;

    private String source;

    private Positions positions;
    private Double salary;
    private Double bonus;
    private Integer workDays;

    @Min(1)
    @Max(100000)
    private int communicationId;

    private int templateId;
    private int productCode;
    private int smsCode;

    public String getTime(){
        return systemTime;
    }

    public String toString(){
        return "{" +
                "uid='" +uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId='" + communicationId + '\'' +
                ", templateId='" + templateId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", smsCode='" + smsCode + '\'' +
                '}';

    }


}
