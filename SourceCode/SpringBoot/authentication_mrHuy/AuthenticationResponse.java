package com.axonactive.iot.sniffermind.authentication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.axonactive.iot.sniffermind.generic.AbstractSingleResponse;
import com.axonactive.iot.sniffermind.generic.ResultStatus;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthenticationResponse extends AbstractSingleResponse<Token>{

	public AuthenticationResponse(Token authentication, ResultStatus resultStatus) {
		super(authentication, resultStatus);
	}
}
