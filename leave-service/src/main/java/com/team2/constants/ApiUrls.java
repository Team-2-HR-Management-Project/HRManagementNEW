package com.team2.constants;

public class ApiUrls {
    public static final String VERSION = "/api/v1";
    public static final String LEAVE = VERSION + "/leave";

    public static final String CREATE = "/create";
    public static final String UPDATE = "/update";
    public static final String UPDATEALL = "/updateall";
    public static final String FIND_BY_ID = "/findbyid";
    public static final String FINDALL="/findall";
    public static final String FINDALL_MANAGER="/findallmanager";
    public static final String FINDALL_EMPLOYEE="/findallemployee";
    public static final String SEE_DETAIL="/seedetail/{authid}";
    public static final String DELETEBYID="/delete/{authid}";
    public static final String ACTIVATE="/activate";
    public static final String ACTIVATEAUTH="/activate/{id}";
    public static final String FINDBYID = "/findbyid/{id}";
    public static final String FINDALLLEAVES = "/findallleaves/{managerid}";
    public static final String FINDMYLEAVES = "/findmyleaves/{authid}";
    public static final String APPROVELEAVE = "/approveleave/{id}";
    public static final String REJECTLEAVE = "/rejectleave/{id}";



}
