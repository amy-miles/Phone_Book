package controller;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


/**
 * 
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Oct 11, 2023
 */
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {
	
	/**
	 * LocalDate and SQL date are two different data types
	 * This converter class automatically converts LocalDate to SQL date
	 */
	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		//if the attribute is null, put null in db field. If not null, use the Date.vlaueOf() method 
		//to change it to the DATE datatype and persist that value
		return (attribute == null ? null : Date.valueOf(attribute));
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {

		return (dbData == null ? null : dbData.toLocalDate());
	}
}
