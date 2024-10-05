package ru.fedorov.secondlab.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    /***
     * Уникальный идентификатор сообщения
     */
    private String uid;
    /***
     * Уникальный идентификатор операции
     */
    private String operationUid;
    /***
     * Системное время
     */
    private String systemTime;
    /***
     * Код выполнения операции
     */
    private Codes code;
    /***
     * Годовая премия
     */
    private Double annualBonus;
    /***
     * Премия
     */
    private Double award;
    /***
     * Код ошибки
     */
    private ErrorCodes errorCode;
    /***
     * Сообщение ошибки
     */
    private ErrorMessages errorMessage;
}
