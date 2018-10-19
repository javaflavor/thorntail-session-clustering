package com.redhat.example.rs;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/count")
public class CounterResource {

	@Inject Counter counter;

	@Inject HttpSession session;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> count() {
		return new LinkedHashMap<String,Object>() {{
			put("sessionId", session.getId());
			put("requestCount", counter.increment());
			put("host", System.getProperty("swarm.node.id", "N/A"));
		}};
	}
}
