package org.example.constaints;

public class EndPoints {
    public static final String CREATE_SPACE_URI = "/team/{team_id}/space";
    public static final String UPDATE_SPACE_URI = "/space/{space_id}";
    public static final String GET_SPACE_URI = "/space/{space_id}";
    public static final String GET_SPACES_URI = "/team/{team_id}/space";
    public static final String DELETE_SPACE_URI = "/space/{space_id}";

    //Folder

    public static final String CREATE_FOLDER_URI = "/space/{space_id}/folder";
    public static final String UPDATE_FOLDER_URI = "/folder/{folder_id}";
    public static final String DELETE_FOLDER_URI = "/folder/{folder_id}";
    public static final String GET_FOLDER_URI = "/folder/{folder_id}";

    //list
    public static final String CREATE_LIST_IN_FOLDER_URI = "/folder/{folder_id}/list";
    public static final String CREATE_LIST_IN_SPACE_URI = "/space/{space_id}/list";
    public static final String DELETE_LIST_URI = "/list/{list_id}";
    public static final String GET_LIST_URI = "/list/{list_id}";
    public static final String GET_LISTS_URI = "/folder/{folder_id}/list";
    public static final String UPDATE_LIST_URI = "/list/{list_id}";

}
