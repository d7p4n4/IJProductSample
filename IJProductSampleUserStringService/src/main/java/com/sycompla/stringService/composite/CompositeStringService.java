package com.sycompla.stringService.composite;

import com.sycompla.composite.*;
import com.sycompla.object.cycleTimeTest.CycleTimeTestObjectService;
import com.sycompla.object.cycleTimeTest.GetListRequest;
import com.sycompla.object.userToken.GetByFbTokenRequest;

public class CompositeStringService {

    public String isUnknownOrInvalidToken(String request) {

        return new CompositeService().isUnknownOrInvalidToken(
                (IsUnknownOrInvalidTokenRequest) new IsUnknownOrInvalidTokenRequest().getFromJson(request)
        ).getAsJson();

    } // isUnknownOrInvalidToken

    public String getUserFromByToken(String request) {

        return new CompositeService().getUserFromByToken(
                (GetUserFromByTokenRequest) new GetByFbTokenRequest().getFromJson(request)
        ).getAsJson();

    } // getUserFromByToken

    public String getUserGuidByToken(String request) {

        return new CompositeService().getUserGuidByToken(
                (GetUserGuidByTokenRequest) new GetUserGuidByTokenRequest().getFromJson(request)
        ).getAsJson();

    } // getUserGuidByToken

    public String acceptAuthentication(String request) {

        return new CompositeService().acceptAuthentication(
                (AcceptAuthenticationRequest) new AcceptAuthenticationRequest().getFromJson(request)
        ).getAsJson();

    } // acceptAuthentication

    public String signUp(String request) {

        return new CompositeService().signUp(
                (SignUpRequest) new SignUpRequest().getFromJson(request)
        ).getAsJson();

    } // signUp

    public String logIn(String request) {

        return new CompositeService().logIn(
                (LogInRequest) new LogInRequest().getFromJson(request)
        ).getAsJson();

    } // logIn

    public String authentication(String request) {

        return new CompositeService().authentication(
                (AuthenticationRequest) new AuthenticationRequest().getFromJson(request)
        ).getAsJson();

    } // authentication


} // CompositeStringService
