package com.sycompla.composite;

import ac4y.service.domain.Ac4yProcessResult;
import com.sycompla.object.user.GetByGuidRequest;
import com.sycompla.object.user.GetByGuidResponse;
import com.sycompla.object.user.IsExistsByGuidRequest;
import com.sycompla.object.user.IsExistsByGuidResponse;
import com.sycompla.object.user.UserObjectService;
import com.sycompla.object.userToken.*;

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

    public GetUserFromByTokenResponse getUserFromByToken(GetUserFromByTokenRequest request) {

        GetUserFromByTokenResponse response = new GetUserFromByTokenResponse();

        try {

            IsExistsByFbTokenResponse isExistsByFbTokenResponse = new UserTokenObjectService()
                    .isExistsByFbToken(new IsExistsByFbTokenRequest(
                            request.getFbToken()
                    ));

            if(isExistsByFbTokenResponse.getResult().getCode() == 1) {

                GetByFbTokenResponse getByFbTokenResponse = new UserTokenObjectService()
                        .getByFbToken(new GetByFbTokenRequest(
                                request.getFbToken()
                        ));

                IsExistsByGuidResponse isExistsByGuidResponse = new UserObjectService()
                        .isExistsByGuid(new IsExistsByGuidRequest(
                                getByFbTokenResponse.getUserToken().getUserGuid()
                        ));

                if(isExistsByGuidResponse.getResult().getCode() == 1) {

                    GetByGuidResponse getByGuidResponse = new UserObjectService()
                            .getByGuid(new GetByGuidRequest(
                                    getByFbTokenResponse.getUserToken().getUserGuid()
                            ));

                    response.setUser(getByGuidResponse.getUser());

                    response.setResult(
                            new Ac4yProcessResult(
                                    1
                                    , "ok"
                                    , null
                            )
                    );

                } else {

                    response.setResult(
                            new Ac4yProcessResult(
                                    -1
                                    , "nem létezik a guid-al user "
                                    , null
                            )
                    );

                }

            } else {

                response.setResult(
                        new Ac4yProcessResult(
                                -1
                                , "létezik a token"
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

    } // GetUserFromByToken

} // CompositeService
