package com.learningRest.MTI.features;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;

import com.learningRest.MTI.DTO.ResponseDTO.PostCreationResponseDTO;
import com.learningRest.MTI.serviceactions.PostDetails;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManagePostsDetails {

	PostDetails postDetails = new PostDetails();

	@When("^I hit a Get Request to fetch Post with PostID \"([^\"]*)\"$")
	public void i_hit_a_Get_Request_to_fetch_Post_with_PostID(String postID) throws Throwable {
		postDetails.testGetRequestForPostDetails(postID);
	}

	@When("^I hit a Post Request to create Post with below Request body$")
	public void i_hit_a_Post_Request_to_create_Post_with_below_Request_body(DataTable requestBody) throws Throwable {
		List<Map<String, String>> requestData = requestBody.asMaps(String.class, String.class);
		postDetails.testPostRequest(requestData.get(0));

	}

	@Then("^the API Response Status Code should be (\\d+)$")
	public void the_API_Response_Status_Code_should_be(int expectedStatusCode) throws Throwable {
		int actualStatusCode = postDetails.getResponseStatusCode();
		Assertions.assertThat(actualStatusCode).isEqualTo(expectedStatusCode);

	}

	@Then("^the API Response Body would contain following values$")
	public void the_API_Response_Body_would_contain_following_values(DataTable responseBody) throws Throwable {

		List<Map<String, String>> responseData = responseBody.asMaps(String.class, String.class);

		// | title | body | userID | id |

		PostCreationResponseDTO expectedResponse = new PostCreationResponseDTO(responseData.get(0).get("title"),
				responseData.get(0).get("body"), Integer.parseInt(responseData.get(0).get("userID")),
				Integer.parseInt(responseData.get(0).get("id")));

		System.out.println(expectedResponse);

	}

}
