package com.sycompla.composite;

import ac4y.service.domain.Ac4yProcessResult;
import com.sycompla.object.userToken.IsExistsByFbTokenRequest;
import com.sycompla.object.userToken.IsExistsByFbTokenResponse;
import com.sycompla.object.userToken.UserTokenObjectService;

public class CompositeService {

    public IsUnknownOrInvalidTokenResponse isUnknownOrInvalidToken(IsUnknownOrInvalidTokenRequest request) {

        IsUnknownOrInvalidTokenResponse response = new IsUnknownOrInvalidTokenResponse();

        try {

            IsExistsByFbTokenResponse isExistsByFbTokenResponse = new UserTokenObjectService()
                    .isExistsByFbToken(new IsExistsByFbTokenRequest(
                            request.getFbToken()
                    ));

            if(isExistsByFbTokenResponse.getResult().getCode() == 1) {

                response.setResult(
                        new Ac4yProcessResult(
                                -1
                                , "létezik a token"
                                , null
                        )
                );

            } else {

                response.setResult(
                        new Ac4yProcessResult(
                                1
                                , "a token nem létezik"
                                , null
                        )
                );

            }

        } catch (Exception exception) {

            response.setResult(
                    new Ac4yProcessResult(
                            -1
                            , exception.getMessage()
                            , null
                    )
            );

        }

        return response;

    } // isUnknownOrInvalidToken

} // CompositeService
