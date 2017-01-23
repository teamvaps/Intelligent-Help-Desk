package edu.cpp.cs580.data.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.cpp.cs580.data.User;
import edu.cpp.cs580.data.UserMap;
import edu.cpp.cs580.util.ResourceResolver;

/**
 * The implementation of {@link UserManager} interface
 * using file system.
 * <p>
 * This class demonstrates how you can use the file system
 * as a database to store your data.
 *
 */
public class FSUserManager implements UserManager {

	/**
	 * We persist all the user related objects as JSON.
	 * <p>
	 * For more information about JSON and ObjectMapper, please see:
	 * http://www.journaldev.com/2324/jackson-json-processing-api-in-java-example-tutorial
	 *
	 * or Google tons of tutorials
	 *
	 */
	private static final ObjectMapper JSON = new ObjectMapper();

	/**
	 * Load the user map from the local file.
	 *
	 * @return
	 */
	private UserMap getUserMap() {
		UserMap userMap = null;
		File userFile = ResourceResolver.getUserFile();
		if (userFile.exists()) {
			// read the file and convert the JSON content
			// to the UserMap object
			try {
				userMap = JSON.readValue(userFile, UserMap.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			userMap = new UserMap();
		}
		return userMap;
	}

	/**
	 * Save and persist the user map in the local file.
	 *
	 * @param userMap
	 */
	private void persistUserMap(UserMap userMap) {
		try {
			// convert the user object to JSON format
			JSON.writeValue(ResourceResolver.getUserFile(), userMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(String userId) {
		UserMap userMap = getUserMap();
		return userMap.get(userId);
	}

	@Override
	public void updateUser(User user) {
		UserMap userMap = getUserMap();
		userMap.put(user.getId(), user);
		persistUserMap(userMap);
	}

	@Override
	public void deleteUser(String userId) {
		UserMap userMap = getUserMap();
		userMap.remove(userId);
		persistUserMap(userMap);
	}

	@Override
	public List<User> listAllUsers() {
		UserMap userMap = getUserMap();
		return new ArrayList<User>(userMap.values());
	}


	@Override
	public List<User> getUserWithMajors(String major) {
		ArrayList<User> list = new ArrayList<User>();
		UserMap userMap = getUserMap();
		for(Entry<String, User> u : userMap.entrySet()){
			if(u.getValue().getMajor().equals(major)){
				list.add(u.getValue());
			}
		}

		return list;
	}
}
