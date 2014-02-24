package org.codingpedia.demo.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codingpedia.demo.rest.dao.PodcastDao;
import org.codingpedia.demo.rest.entities.Podcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * Service class that handles REST requests
 * 
 * @author amacoder
 * 
 */
@Component
@Path("/legacy/podcasts")
public class PodcastLegacyRestService {

	@Autowired
	private PodcastDao podcastDao;

	/************************************ READ ************************************/
	/**
	 * Returns all resources (podcasts) from the database
	 * 
	 * @return
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Podcast> getPodcasts() {
		return podcastDao.getLegacyPodcasts();
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findById(@PathParam("id") Long id) {
		Podcast podcastById = podcastDao.getLegacyPodcastById(id);
		if (podcastById != null) {
			return Response.status(200).entity(podcastById).build();
		} else {
			return Response
					.status(404)
					.entity("The podcast with the id " + id + " does not exist")
					.build();
		}
	}

}
