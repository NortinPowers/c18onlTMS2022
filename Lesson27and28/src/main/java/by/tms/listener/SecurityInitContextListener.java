package by.tms.listener;

//@WebListener
//public class SecurityInitContextListener implements ServletContextListener {
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        Map<String, String> accessMap = new HashMap<>();
////        accessMap.put("test", "test");
//        Authenticator authenticator = new Authenticator(accessMap);
//        SecurityAware security = new SecurityService(authenticator);
//        sce.getServletContext().setAttribute("security", security);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        sce.getServletContext().setAttribute("security", null);
//    }
//}