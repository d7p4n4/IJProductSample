package com.sycompla.composite;

import ac4y.service.domain.Ac4yProcessResult;
import com.sycompla.entity.UserToken;
import com.sycompla.object.user.GetByGuidRequest;
import com.sycompla.object.user.GetByGuidResponse;
import com.sycompla.object.user.InsertRequest;
import com.sycompla.object.user.InsertResponse;
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

    public GetUserGuidByTokenResponse getUserGuidByToken(GetUserGuidByTokenRequest request) {

        GetUserGuidByTokenResponse response = new GetUserGuidByTokenResponse();

        try {

            IsExistsByFbTokenResponse isExistsByFbTokenResponse = new UserTokenObjectService()
                    .isExistsByFbToken(new IsExistsByFbTokenRequest(
                            request.getFbToken()
                    ));

            if (isExistsByFbTokenResponse.getResult().getCode() == 1) {

                GetByFbTokenResponse getByFbTokenResponse = new UserTokenObjectService()
                        .getByFbToken(new GetByFbTokenRequest(
                                request.getFbToken()
                        ));

                IsExistsByGuidResponse isExistsByGuidResponse = new UserObjectService()
                        .isExistsByGuid(new IsExistsByGuidRequest(
                                getByFbTokenResponse.getUserToken().getUserGuid()
                        ));

                if(isExistsByGuidResponse.getResult().getCode() == 1) {
                    /*
                    GetByGuidResponse getByGuidResponse = new UserObjectService()
                            .getByGuid(new GetByGuidRequest(
                                    getByFbTokenResponse.getUserToken().getUserGuid()
                            ));*/

                    response.setGuid(getByFbTokenResponse.getUserToken().getUserGuid());

                } else {

                    response.setResult(
                            new Ac4yProcessResult(
                                    -1
                                    , "a guid-val nem létezik user"
                                    , null
                            )
                    );

                }
            } else {

                response.setResult(
                        new Ac4yProcessResult(
                                -1
                                , "nem létezik a token"
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

    } // getUserGuidByToken

    public AcceptAuthenticationResponse acceptAuthentication(AcceptAuthenticationRequest request) {

        AcceptAuthenticationResponse response = new AcceptAuthenticationResponse();

        try {

            if(request.getGuid() != null && !request.getGuid().trim().isEmpty() && request.getCheckData() != null && !request.getCheckData().trim().isEmpty()) {

                response.setResult(
                        new Ac4yProcessResult(
                                1
                                , "a guid és a checkData sem üres"
                                , null
                        )
                );

            } else {

                response.setResult(
                        new Ac4yProcessResult(
                                -1
                                , "valamelyik érték üres"
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

    } // acceptAuthentication

    public SignUpResponse signUp(SignUpRequest request) {

        SignUpResponse response = new SignUpResponse();

        try {

            IsExistsByFbTokenResponse isExistsByFbTokenResponse = new UserTokenObjectService()
                    .isExistsByFbToken(new IsExistsByFbTokenRequest(
                            request.getFbToken()
                    ));

            if(isExistsByFbTokenResponse.getResult().getCode() == 1) {

                response.setResult(
                        new Ac4yProcessResult(
                                -1
                                , "ezzel a tokennel már létezik user"
                                , null
                        )
                );

            } else {

                InsertResponse insertResponse = new UserObjectService()
                        .insert(new InsertRequest(
                                request.getUser()
                        ));

                if(insertResponse.getResult().getCode() == 1) {

                    UserToken userToken = new UserToken(
                            insertResponse.getUser().getGuid()
                            , request.getFbToken()
                    );

                    com.sycompla.object.userToken.InsertResponse insertResponseUserToken = new UserTokenObjectService()
                            .insert(new com.sycompla.object.userToken.InsertRequest(
                                    userToken
                            ));

                    if(insertResponseUserToken.getResult().getCode() == 1) {

                        response.setResult(
                                new Ac4yProcessResult(
                                        1
                                        , "a sign up sikeres volt"
                                        , null
                                )
                        );

                    } else {

                        response.setResult(
                                new Ac4yProcessResult(
                                        -1
                                        , "a userToklen inswert nem sikerült"
                                        , null
                                )
                        );

                    }

                } else {

                    response.setResult(
                            new Ac4yProcessResult(
                                    -1
                                    , "a user insert nem sikerült"
                                    , null
                            )
                    );

                }

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

    } // signUp

} // CompositeService
