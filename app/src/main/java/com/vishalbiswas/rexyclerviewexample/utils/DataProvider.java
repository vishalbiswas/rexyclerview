package com.vishalbiswas.rexyclerviewexample.utils;

import com.google.gson.Gson;
import com.vishalbiswas.rexyclerviewexample.models.Category;

import java.util.List;

public final class DataProvider {
    private static final Gson gson = new Gson();
    private static final String categories = "[{\"id\":1,\"name\":\"Real Estate\",\"childItems\":[{\"id\":8,\"name\":\"Services\",\"childItems\":[{\"id\":9,\"name\":\"Appraisal\",\"childItems\":[]},{\"id\":10,\"name\":\"Financing\",\"childItems\":[]},{\"id\":11,\"name\":\"Property Management\",\"childItems\":[]},{\"id\":12,\"name\":\"Sales/Leasing\",\"childItems\":[]},{\"id\":13,\"name\":\"Tax Appeal\",\"childItems\":[]},{\"id\":14,\"name\":\"1031/DST\",\"childItems\":[]},{\"id\":15,\"name\":\"Title Co's\",\"childItems\":[]},{\"id\":16,\"name\":\"QI\",\"childItems\":[]},{\"id\":17,\"name\":\"Legal\",\"childItems\":[]}]},{\"id\":18,\"name\":\"Properties for Sale\",\"childItems\":[{\"id\":19,\"name\":\"Owner-User Properties\",\"childItems\":[{\"id\":41,\"name\":\"Industrial\",\"childItems\":[]},{\"id\":42,\"name\":\"Medical\",\"childItems\":[]},{\"id\":43,\"name\":\"Multi-Family\",\"childItems\":[]},{\"id\":44,\"name\":\"Office\",\"childItems\":[]},{\"id\":45,\"name\":\"Retail\",\"childItems\":[]}]},{\"id\":20,\"name\":\"Investment Properties\",\"childItems\":[{\"id\":46,\"name\":\"Industrial\",\"childItems\":[]},{\"id\":47,\"name\":\"Medical\",\"childItems\":[]},{\"id\":48,\"name\":\"Multi-Family\",\"childItems\":[]},{\"id\":49,\"name\":\"Office\",\"childItems\":[]},{\"id\":50,\"name\":\"Retail\",\"childItems\":[]}]},{\"id\":21,\"name\":\"Zero Cash Flow\",\"childItems\":[{\"id\":51,\"name\":\"Industrial\",\"childItems\":[]},{\"id\":52,\"name\":\"Medical\",\"childItems\":[]},{\"id\":53,\"name\":\"Multi-Family\",\"childItems\":[]},{\"id\":54,\"name\":\"Office\",\"childItems\":[]},{\"id\":55,\"name\":\"Retail\",\"childItems\":[]}]},{\"id\":22,\"name\":\"Opportunity Zone Fund\",\"childItems\":[{\"id\":23,\"name\":\"Industrial\",\"childItems\":[]},{\"id\":24,\"name\":\"Medical\",\"childItems\":[]},{\"id\":25,\"name\":\"Multi-Family\",\"childItems\":[]},{\"id\":26,\"name\":\"Office\",\"childItems\":[]},{\"id\":27,\"name\":\"Retail\",\"childItems\":[]}]}]},{\"id\":56,\"name\":\"Invest in this project\",\"childItems\":[{\"id\":57,\"name\":\"Industrial\",\"childItems\":[]},{\"id\":58,\"name\":\"Medical\",\"childItems\":[]},{\"id\":59,\"name\":\"Multi-Family\",\"childItems\":[]},{\"id\":60,\"name\":\"Office\",\"childItems\":[]},{\"id\":61,\"name\":\"Retail\",\"childItems\":[]}]}]},{\"id\":2,\"name\":\"Vacation Rental\",\"childItems\":[{\"id\":28,\"name\":\"Domestic\",\"childItems\":[]},{\"id\":29,\"name\":\"Foreign\",\"childItems\":[]}]},{\"id\":3,\"name\":\"Automobile\",\"childItems\":[{\"id\":30,\"name\":\"Services\",\"childItems\":[{\"id\":32,\"name\":\"Insurance\",\"childItems\":[]},{\"id\":33,\"name\":\"Speciality Items\",\"childItems\":[]}]},{\"id\":31,\"name\":\"Sales\",\"childItems\":[{\"id\":34,\"name\":\"Domestic\",\"childItems\":[]},{\"id\":35,\"name\":\"Foreign\",\"childItems\":[]}]}]},{\"id\":4,\"name\":\"Banking\",\"childItems\":[{\"id\":36,\"name\":\"Business Banking\",\"childItems\":[]},{\"id\":37,\"name\":\"Investment Banking\",\"childItems\":[]}]},{\"id\":5,\"name\":\"Insurance\",\"childItems\":[{\"id\":38,\"name\":\"Commercial\",\"childItems\":[]},{\"id\":39,\"name\":\"Residential\",\"childItems\":[]},{\"id\":40,\"name\":\"Auto\",\"childItems\":[]}]},{\"id\":6,\"name\":\"Wealth Management\",\"childItems\":[]},{\"id\":7,\"name\":\"Merchandise / Tickets\",\"childItems\":[]}]";

    public static Category[] getCategories() {
        return gson.fromJson(categories, Category[].class);
    }
}
