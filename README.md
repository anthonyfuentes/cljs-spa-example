# Sample CLJS SPA

### High-Level Dependencies
 - npm
 - shadow-cljs (global, recommended) ***or...***
	* `sudo npm i -g shadow-cljs`
 - npx (global)
	* `sudo npm i -g npx`
### Setup
0. Get the source code to your dev environment
1. Install project dependencies
	* `npm install` from the project root

### Builds
If you opted to install npx globally instead of shadow-cljs, prefix the commands below with `npx` e.g. `$ npx shadow-cljs ...`

Note: builds _can_ be watched simultaneously
- `shadow-cljs watch app`
	* Anytime a source file, `/src/main/*`, is modified, the browser reloads
	* Development server can be reached at `localhost:3333` - can be changed in `shadow-cljs.edn`
- `shadow-cljs watch test`
	* Anytime a test file, `/src/test/*`, or test subject, `/src/main/*`, is modified, tests run
