package com.examples.gcloud.pubsub.controller;

import com.examples.gcloud.pubsub.PubSubApplication.PubsubOutboundGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GcloudPubsubController {

	@Autowired
	private PubsubOutboundGateway messagingGateway;

	@PostMapping("/publishMessage")
	public String publishMessage(@RequestParam("message") String message) {
		messagingGateway.sendToPubsub(message);
		return "Message published to Google Pubsub successfully.";
	}
}
