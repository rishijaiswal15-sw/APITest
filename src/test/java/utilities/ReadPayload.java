package utilities;

import io.restassured.path.json.JsonPath;

public class ReadPayload {
	public static String getPromotionDescription(JsonPath jsonResponse, String jsonKey)

	{

		String actualDescription = null;

		for (int i = 0; i < jsonResponse.getInt(jsonKey + ".size()"); i++)

		{

			if (jsonResponse.get(jsonKey + "[" + i + "].Name").equals("Gallery"))

			{

				actualDescription = jsonResponse.get(jsonKey + "[" + i + "].Description");

				break;

			}

			else

				continue;

		}

		return actualDescription;

	}

}
