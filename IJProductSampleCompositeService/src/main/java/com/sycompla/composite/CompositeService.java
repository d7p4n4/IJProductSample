package com.sycompla.composite;

import ac4y.service.domain.Ac4yProcessResult;
import com.sycompla.entity.RequestToken;
import com.sycompla.entity.UserToken;
import com.sycompla.object.requestToken.RequestTokenObjectService;
import com.sycompla.object.user.GetByGuidRequest;
import com.sycompla.object.user.GetByGuidResponse;
import com.sycompla.object.user.InsertRequest;
import com.sycompla.object.user.InsertResponse;
import com.sycompla.object.user.IsExistsByGuidRequest;
import com.sycompla.object.user.IsExistsByGuidResponse;
import com.sycompla.object.user.UserObjectService;
import com.sycompla.object.userToken.*;
import okhttp3.*;

import java.util.Random;

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

    public LogInResponse logIn(LogInRequest request) {

        LogInResponse response = new LogInResponse();

        try {

            IsUnknownOrInvalidTokenResponse isUnknownOrInvalidTokenResponse = isUnknownOrInvalidToken(
                    new IsUnknownOrInvalidTokenRequest(
                        request.getFbToken()
                )
            );

            if(isUnknownOrInvalidTokenResponse.getResult().getCode() == -1) {

                GetUserFromByTokenResponse getUserFromByTokenResponse = getUserFromByToken(
                        new GetUserFromByTokenRequest(
                                request.getFbToken()
                        )
                );

                if(getUserFromByTokenResponse.getResult().getCode() == 1) {

                    int checkData = new Random().nextInt();

                    RequestToken requestToken = new RequestToken(
                            getUserFromByTokenResponse.getUser().getGuid()
                            , Integer.toString(checkData)
                    );

                    com.sycompla.object.requestToken.IsExistsByGuidResponse isExistsGuidResponseRequestToken = new RequestTokenObjectService()
                            .isExistsByGuid(new com.sycompla.object.requestToken.IsExistsByGuidRequest(
                                    getUserFromByTokenResponse.getUser().getGuid()
                            ));

                    if(isExistsGuidResponseRequestToken.getResult().getCode() == -1) {

                        com.sycompla.object.requestToken.InsertResponse insertResponseRequestToken = new RequestTokenObjectService()
                                .insert(new com.sycompla.object.requestToken.InsertRequest(
                                        requestToken
                                ));

                        if(insertResponseRequestToken.getResult().getCode() == 1) {

                            response.setRequestToken(requestToken);

                            response.setResult(
                                    new Ac4yProcessResult(
                                            1
                                            , "sikeres login"
                                            , null
                                    )
                            );

                        } else {

                            response.setResult(
                                    new Ac4yProcessResult(
                                            -1
                                            , "a request token insert nem sikerült"
                                            , null
                                    )
                            );

                        }

                        return response;

                    } else {

                        com.sycompla.object.requestToken.UpdateByGuidResponse updateByGuidResponseRequestToken = new RequestTokenObjectService()
                                .updateByGuid(new com.sycompla.object.requestToken.UpdateByGuidRequest(
                                        requestToken.getGuid()
                                        , requestToken
                                ));

                        if(updateByGuidResponseRequestToken.getResult().getCode() == 1) {

                            response.setRequestToken(requestToken);

                            response.setResult(
                                    new Ac4yProcessResult(
                                            1
                                            , "sikeres login checkData frissitéssel"
                                            , null
                                    )
                            );

                        } else {

                            response.setResult(
                                    new Ac4yProcessResult(
                                            -1
                                            , "a request token update nem sikerült"
                                            , null
                                    )
                            );

                        }

                        return response;

                    }

                } else {

                    response.setResult(
                            new Ac4yProcessResult(
                                    -1
                                    , "nincs az adott tokennel user"
                                    , null
                            )
                    );

                }

            } else {

                response.setResult(
                        new Ac4yProcessResult(
                                -1
                                , "a token ismeretlen vagy lejárt"
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

    } // logIn

    public AuthenticationResponse authentication(AuthenticationRequest request) {

        AuthenticationResponse response = new AuthenticationResponse();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"to\": \"" + request.getFbToken() + "\"\r\n\r\n    , \"data\": {\r\n        \"checkData\": \"" + request.getCheckData() + "\"\r\n    }\r\n}");
        Request requestOk = new Request.Builder()
                .url("https://fcm.googleapis.com/fcm/send")
                .method("POST", body)
                .addHeader("Authorization", "key=AAAAMrfsOZQ:APA91bE_BRElbjcU7XZyAZn6Yw8C8bhOS1vd3gWGch9am14IepEIJleW_ZKGACIyGzz3gxuQpLwVUcZuZcsRWg7k0UbnJ3_SWL87tCT41I6ALga7lnANK-WlhV94mOn5b08mIVaVv1Dx")
                .addHeader("Content-Type", "application/json")
                .build();
        Call call = client.newCall(requestOk);


        try {

            Response responseClient = call.execute();

            ResponseBody responseBody = responseClient.body();

            System.out.println(responseBody);

            response.setResult(
                    new Ac4yProcessResult(
                            1
                            , "ok"
                            , null
                    )
            );

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

    }  // authentication

} // CompositeService
