package com.sparta.northwindapi.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class MainController implements ErrorController {

    @RequestMapping("error")
    public String handleError(HttpServletRequest request) {
        // Create base redirect URI
        StringBuilder returnVal = new StringBuilder("errors/");

        // Get status code
        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        // Check that status code isn't null
        if (statusCode == null) return returnVal.append("error-fallback.html").toString();

        // Append appropriate status code message
        returnVal.append(switch (Integer.parseInt(statusCode.toString())) {
            case 400 -> { yield "bad-request.html"; }
            case 401 -> { yield "unauthorised.html"; }
//            case 402 -> { yield "payment-required.html"; }
//            case 403 -> { yield "forbidden.html"; }
            case 404 -> { yield "not-found.html"; }
//            case 405 -> { yield "method-not-allowed.html"; }
//            case 406 -> { yield "not-acceptable.html"; }
//            case 407 -> { yield "proxy-authentication-required.html"; }
//            case 408 -> { yield "request-timeout.html"; }
//            case 409 -> { yield "conflict.html"; }
//            case 410 -> { yield "gone.html"; }
//            case 411 -> { yield "length-required.html"; }
//            case 412 -> { yield "precondition-failed.html"; }
//            case 413 -> { yield "payload-too-large.html"; }
//            case 414 -> { yield "uri-too-long.html"; }
//            case 415 -> { yield "unsupported-media-type.html"; }
//            case 416 -> { yield "requested-range-not-satisfiable.html"; }
//            case 417 -> { yield "expectation-failed.html"; }
//            case 418 -> { yield "im-a-teapot.html"; }
//            case 422 -> { yield "unprocessable-entity.html"; }
//            case 423 -> { yield "locked.html"; }
//            case 424 -> { yield "failed-dependency.html"; }
//            case 425 -> { yield "too-early.html"; }
//            case 426 -> { yield "upgrade-required.html"; }
//            case 428 -> { yield "precondition-required.html"; }
//            case 429 -> { yield "too-many-requests.html"; }
//            case 431 -> { yield "request-header-fields-too-large.html"; }
//            case 451 -> { yield "unavailable-for-legal-reasons.html"; }
//            case 500 -> { yield "internal-server-error.html"; }
//            case 501 -> { yield "not-implemented.html"; }
//            case 502 -> { yield "bad-gateway.html"; }
//            case 503 -> { yield "service-unavailable.html"; }
//            case 504 -> { yield "gateway-timeout.html"; }
//            case 505 -> { yield "http-version-not-supported.html"; }
//            case 506 -> { yield "variant-also-negotiates.html"; }
//            case 507 -> { yield "insufficient-storage.html"; }
//            case 508 -> { yield "loop-detected.html"; }
//            case 509 -> { yield "bandwidth-limit-exceeded.html"; }
//            case 510 -> { yield "not-extended.html"; }
//            case 511 -> { yield "network-authentication-required.html"; }
            default -> { yield "error-fallback.html"; }
        });

        return returnVal.toString();
    }

}