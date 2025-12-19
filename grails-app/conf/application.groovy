// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'harsh.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'harsh.UserRole'
grails.plugin.springsecurity.authority.className = 'harsh.Role'
grails.plugin.springsecurity.useBasicAuth = false
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
]

grails.plugin.springsecurity.filterChain.filterNames = [
        'securityContextPersistenceFilter',
        'logoutFilter',
        'jwtTokenValidationFilter',
        'anonymousAuthenticationFilter',
        'exceptionTranslationFilter',
        'filterInvocationInterceptor'
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/login',          filters: 'none'],
	[pattern: '/employee/**',    filters: 'JOINED_FILTERS'],
    [pattern: '/**',             filters: 'JOINED_FILTERS']
]

