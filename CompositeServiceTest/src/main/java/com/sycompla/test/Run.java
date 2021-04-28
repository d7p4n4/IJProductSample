package com.sycompla.test;

import com.sycompla.composite.AuthenticationRequest;
import com.sycompla.composite.AuthenticationResponse;
import com.sycompla.composite.CompositeService;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;

public class Run {

    //private static final Logger LOG = LogManager.getLogger(Run.class);

    public AuthenticationResponse authentication() {

        AuthenticationResponse authenticationResponse = new CompositeService()
                .authentication(new AuthenticationRequest(
                        "556152"
                        , "elfFf623jS3uKQJVnggORW:APA91bEdHHF9v3M1lZh3dSLLRh_aQshNEtmP_RILYlSn3e8dEznWLyOw2tMVFbmm9iXkgoKl7LAViPsI6n4anfm3LPB-DJZ1Q43FxvFSst5g8mH0N4qL5vlNgbtMeny63zNV3WpypKHn"
                ));

        return authenticationResponse;

    } // authentication

    public static void main(String[] args) {

        new Run().authentication();

    } // main

} // Run