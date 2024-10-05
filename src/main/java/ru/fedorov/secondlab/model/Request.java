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
    /***
     * Уникальный идентификатор сообщения
     */
    @NotBlank(message = "UID не может быть пустым")
    @Size(max= 32)
    private String uid;
    /***
     * Уникальный идентификатор операции
     */
    @NotBlank
    @Size(max= 32)
    private String operationUid;
    /***
     * Имя системы
     */
    private String systemName;
    /***
     * Системное время
     */
    @NotBlank
    private String systemTime;
    /***
     * Источник
     */
    private String source;
    /***
     * Должность
     */
    private Positions positions;
    /***
     * Зарплата
     */
    private Double salary;
    /***
     * Бонус к зарплате
     */
    private Double bonus;
    /***
     * Рабочие дни
     */
    private Integer workDays;

    /***
     * Уникальный идентификатор коммуникации
     */
    @Min(1)
    @Max(100000)
    private int communicationId;
    /***
     * Идентификатор шаблона
     */
    private int templateId;
    /***
     * Код продукта
     */
    private int productCode;
    /***
     * Смс код
     */
    private int smsCode;

    public String toString(){
        return "{" +
                "uid='" +uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", positions='" + positions + '\'' +
                ", salary='" + salary + '\'' +
                ", bonus='" + bonus + '\'' +
                ", workdays='" + workDays + '\'' +
                ", communicationId='" + communicationId + '\'' +
                ", templateId='" + templateId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", smsCode='" + smsCode + '\'' +
                '}';

    }


}
