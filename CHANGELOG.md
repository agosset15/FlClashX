# Changelog

## v0.5.10 (2026-11-24)

**Features**

- Optional apple and s3 (8631eab)

## v0.5.9 (2026-11-23)

**Features**

- Move to KAGO branding (e1d24ea)
- Redesign connections page вЂ” tabs, app/exe icons, destination flags, zashboard button (ab08aec)
- Classic navbar with old dashboard, hero navbar with new (836ca4f)
- Show core version in build-core run name (ba0ff16)
- Domain-redirect via flclashx-newdomain header (7d8f2d2)
- Core-side health check, delay test error handling, UI tooltips (256e36f)
- Android notification/tile/battery rework, shortcuts, desktop socket leak fix, macOS entitlement (cb375d7)
- Hwid headers update, merge provider headers on update, yaml highlight (6042cd0)
- Yaml highlight controller, editor rewrite, runtime config highlight (89853b0)
- GetCoreVersion IPC action, update UI fixes, revert ARM builds (f9090af)
- Core update progress bar and update highlight (2e64069)
- New tray icon, new title bar (a000acb)
- New readme (d805e7b)
- 3 days notice of expiring subscription every day (only Android for now) (a6629f5)
- New header flclashx-globalmode feat: visible servicename and host in foreground notify fix: update dependencies packages fix: flclashx-custom logic fix: windows installer fix: update logic empty widgets visible fix: update notify TG (6cfef7e)
- Manually check ip from networkDetection widget (3bb505b)
- Add restart button in tray control feat: new pop-up window when HWID Limit is reached (aad6cc7)
- Add button to check latency across all proxy groups feat: new header flclashx-hex (custom theme app) fix: search button in proxy groups fix: setting up proxy group sorting (5a8b7bb)
- Logs folder button in settings menu refactor: about page (9aed3be)
- Logger in file (logrotate10 days) (8daaf10)
- Add flclashx-backgroud header (the ability to customize the application background) feat: button to hide/show all proxy groups fix: kill application when installing over an older version (dae0ee6)
- Recive parameters from a subscription and enabling from an override in client: allow-lan, ipv6, find-process-mode, tun-stack feat: the ability to completely reset application profiles from settings (a215698)
- Universal APK feat: new UI for geofiles menu feat: Application settings from sub-header (disableable setting override) feat: saving custom settings from the profile header fix: custom geofiles loader (check hash from URL) fix: safe_patch error fix: metainfo widget logical fix: localization (9bbc835)
- **release** Add Repology badge for FlClashX version tracking (258ee60)
- **dashboard** Enhance MetainfoWidget with improved expiration display and UI adjustments (9037bb7)
- **build** Clean up build workflow (813e2a7)
- **dashboard** Add serviceInfo widget and update profile handling (5b8c0a0)
- **proxy** Enhance proxy card functionality and UI (6415f2b)
- **proxy** Enhance proxy handling with server descriptions and JSON integration (ddc3358)
- **macos** Adjust popover dimensions and enhance macOS app layout (ec8323c)
- **dashboard** Enhance StartButton with animation and tap feedback (a879425)
- **localization** Add "Change Server" string to multiple language files and update UI elements for macOS (b29a193)
- **build** Enhance Makefile and Xcode project for macOS notarization and code signing (ea5656b)
- **macos** Implement native status bar and code signing support (72ef0de)

**Bug Fixes**

- Newboard header via flclashx-custom (update=every apply, add=on first add), unlock toggle (c654d4b)
- Android battery drain, instant host pings, launch flow and tun lifecycle, macos dns (43e2dec)
- Remove duplicate branch input from build-core, use workflow_dispatch ref (3c2338e)
- Ip-check sequential with timeouts, fix announce emoji on new dashboard, android tun re-setup on connect, feat: vendor utls firefox148/safari26, bump mihomo core 1.19.27, feat: tv phone-sync, flclashx-override global, buy buttons (446ebb3)
- Subtle primary tint on hero card when active (e511721)
- Unify support icon to contact_support everywhere (2178be8)
- Remove scroll, use AnimatedContainer for card bg transition (c16ea9c)
- Increase bottom padding to 32px (135c29d)
- Add bottom safe area padding for Android navigation bar (c9542a0)
- VPN cold-start NPE, editor line numbers, build-core version update (2ac738f)
- Health check loading indicator and generated enum map (d67088d)
- Process name detection, geo download timeout, windows arm64 build (abff839)
- Windows arm64 build path (a3fc28a)
- Inno setup template, file naming, linux deb/rpm/appimage, kotlin version (42d5a0d)
- Desktop socket race condition, battery prompt once, build improvements (4c6f33a)
- Editor content scroll with expands + maxLines (7ea0fdf)
- Editor wrap, scroll, dark theme support (6f770ea)
- Remove version from restart core button (416fb4f)
- Add getCoreVersion to ActionMethodEnumMap (was missing in generated code) (7fb3020)
- Core update version display, workflow input simplification (a04dbfd)
- Check core version from running instance, not build constant (c0844ef)
- Remove unused shutdown_service function (e9982a4)
- Stop core before replacing binary on update (14788af)
- Flutter setup for windows arm and linux arm runners (61c3c25)
- Install flutter from git on ARM runners (2568727)
- Pin flutter version for ARM runners (9a09417)
- Recreate tun-interface (452debf)
- Mihomo core integration fix: remove overrride tcp-concurrent, unified-delay, log-level, keep-alive-interval feat: custom parameter "description" proxy-group feat: external-ui logic (51737fc)
- App work is performed through the running tun on Android fix: removed validation on mixed port and off sysProxy with mixed-port = 0 fix: corrections for the MATCH field in the override settings fix: include/exclude package on Android feat: new header flclashx-androidsecure, override mixed-port = 0 in Andriod, and hide port setting (a4b131b)
- Update profile autostart app is off (fe00311)
- Readme default hex-theme (1e627ab)
- Tg channel link (9ed2abe)
- ClashHelper installer (abfeb1d)
- Tg notify (73ebc38)
- AndroidTV focusing dpad proxy page (3d628fc)
- Windows logic service fix: Linux arm build (c0568df)
- Added pureblack variant hex header fix: optimize base fix: icon linux-based distrib (3d77df5)
- HWID notify logic fix: removed the proxy group type from the proxy page (b2787b5)
- Android tile service feat: manual check in IPchecker widget feat: mode selector in ProxyPage feat: notify modal in HWID limit fix: logic geo updater (1d9c2dc)
- Android tile service feat: manual check in IPchecker widget feat: mode selector in ProxyPage feat: notify modal in HWID limit fix: logic geo updater (ad1c5dc)
- Cache icons (3d97ed3)
- The proxy tab disappears when renewing a subscription or in other cases (6c5cd94)
- Blur on bottomsheets, sidesheets (c3ee9ea)
- Memtagmode off (temp solution) (a1d4f83)
- Serivceinfo widget base64 issue (a38d14a)
- Backup/restore app function (90a6521)
- Release script (3492ad9)
- Init proxiesgroup for start/stop button (f4bec9b)
- Andriod adaptive icon (97eafbb)
- Release template (c7ed6eb)
- Build pages RepaintBoundary widgets feat: notify release fix: modal pages opacity (bb06855)
- Windows arm actions (cb30c00)
- Coreversion on build app (ad683ba)
- Artefact slidemenu (ad85ba3)
- Serviceinfo and changeserver support latin or base64 header for cyrillic, unicode and emoji support fix: support https:// links announce widget (b0838c3)
- Android icons and splashscreen refactor: changeserverbutton widget fear: new header flclashx-serverinfo refactor: update readme and templates fix: cache logo in service-logo header fix: theme opacity layer (81bbf2d)
- Optimize theme for opacity layers fix: deprecated core version fix: about page (973c44e)
- Release template (1fb8481)
- Visible log folder button on andriod (5ce18d7)
- Gtk flags (39b6c13)
- Workflow (aab6ffd)
- Android hwid generator (Settings.Secure_ID) (b8e09d5)
- Running a single instance on Linux (cfc8b5f)
- Pubsec.yaml (2a2294b)
- Workflow flutter version (b766d0d)
- Locale refactor: recive mixed-port from subscription (1cb0d5d)
- Recieve App Setting from provider fix: en localization update: readme (6e1008f)
- Migrate deprecated iconstyle (6f40708)
- Android notification start bug refactor: cardType fill flexible (4340076)
- Macos naming artifact (72fe70a)
- Notify icon android (bd6d0e1)
- Main settings UI and default variable fix: hwid generator fix: macos version artifact rename (a9ed6e1)
- Pre-release posting gh (e524afb)
- Delete message from update core version (c9dce34)
- Init FlClashX (77942f0)
- Init (df14f42)
- Init universal apk fix: init fork flutter_distributor (b88c0fb)
- **utils** Update time formatting for getTimeText method (7e1e2a0)
- **window_manager** Simplify macOS logic in WindowHeaderContainer and remove unused import (a6708f3)

## v0.5.8 (2026-11-18)

**Features**

- **tray** The tray menu has a Restart item again (df1c1fc)
- **headers** flclashx-special: simple hides the fine settings, leaving the dashboard, proxies, profiles, logs and the basic settings (d10a072)
- **headers** flclashx-special: onlytun keeps the system proxy off and out of the tray and hotkeys; noglobal frees its hotkey and gives Global back on a profile without it (b9ce19f)
- **headers** An Android TV identifies itself to the panel as AndroidTV, in x-device-os and the User-Agent (fb0e2bf)

**Bug Fixes**

- **settings** The filter presets and the excluded domains no longer show Chinese text, stored ones included (a9c3fb8)
- **dashboard** A status card removed from the dashboard stays removed and no longer flashes at startup under denywidgets (dac14fd)
- **dashboard** The service list checks every enabled service as it opens; the card keeps checking only its own tiles (2f43844)
- **dashboard** “All available” on the service card now speaks for every enabled service, not only the tiles shown — thanks to libmur-dev (9b4b58c)
- **profiles** A rule aimed at a group or proxy of the subscription is no longer marked invalid in the profile editor — thanks to libmur-dev (cbbd9f9)
- **profiles** MATCH-TARGET also replaces the subscription’s own MATCH rule — thanks to libmur-dev (18fa160)

## v0.5.7 (2026-11-16)

**Features**

- **headers** Theme, proxies page look, dashboard cards, app switches and the hideip and novibrate specials from a subscription apply only while its profile is selected, and the user's own settings come back on a profile that does not set them (7117ff4)
- **update** An update that finished downloading is installed without downloading again after the dialog was closed, and the installer is removed from the cache once the update is in (5a0ea2d)
- **dashboard** The status card shows the exit IP's country flag; with Hide IP on the app makes no IP checks at all and the flag comes from the server's name (a58aab1)

**Bug Fixes**

- **proxies** With onegroup, Global mode shows the proxies page with its group headers instead of an empty page (11ae136)
- **dashboard** A long announcement is shown in full on a wide window instead of spilling out of its card or losing lines (61e099c)
- **dashboard** With providermode the dashboard stays a centered column on a wide window instead of stretching each card across a row (1bc0f76)
- **core** A proxy name a provider shares with a declared proxy always tests the provider's node instead of either one at random after a restart (d221a9c)
- **macos** The macOS core is built with Go 1.26 again and runs on macOS 12 Monterey (ae557e7)

## v0.5.6 (2026-11-15)

**Features**

- **dashboard** The Core heartbeat is dark green while the Core runs, whatever the theme colour (1e30319)
- **update** Provider update manifests take a minVersion that makes the update required for older apps (e007013)
- **headers** flclashx-view takes proxies.hidetimeout to hide or show proxies that timed out (d608a21)
- **dashboard** The service status card shows the outbound location, a flag and the node's name, instead of the IP (4049f88)
- **android** On Android, pulling the dashboard down updates the subscription and pulling the proxies page down tests the delays (641f761)
- **dashboard** The extended dashboard is replaced by flclashx-special: providermode, which adds the provider's logo, name and a start button to the standard dashboard; app.board is no longer read (02bed3b)

**Bug Fixes**

- **windows** Self-update on Windows recognises installs upgraded from 0.4 instead of treating them as portable (1a434eb)

## v0.5.5 (2026-11-14)

**Features**

- **dashboard** The Core status button shows a heartbeat that morphs between running, connecting and down instead of a green or red fill (3b06ac9)
- **desktop** FlClashX --restart-core restarts the Core of the running app from a script or terminal on Windows, macOS and Linux, with an exit code for the result (#155) (d499d7f)

**Bug Fixes**

- **android** Themed launcher icons show the X alone instead of a dark square around it (ae53900)
- **android** Tapping the Quick Settings tile no longer closes the notification shade (f57fc26)

## v0.5.4 (2026-11-14)

**Features**

- **proxies** The proxies page's top buttons are glass, as on every other page (287aaec)
- **headers** flclashx-special takes onegroup (the proxies page shows only the server group's proxies), nologo (no service logo on the hero page) and noservice (no logo or name there) (2883815)
- **dashboard** Flags on the dashboard and in service status come from the server's name, not the outbound IP's country, and the hero card keeps its swap arrows with the IP hidden (63402f7)
- **profiles** Adding a profile by link asks only for the link, with a one-tap Add from clipboard and the HWID always sent; the dashboard adds by link right away and stays open (a0c08d6)
- **theme** The Background blur switch is gone from Theme settings; it changed nothing visible (4b1018c)
- **dashboard** With the IP hidden, the status card shows the current server, and tapping it changes the server (c5671a0)

**Bug Fixes**

- **profiles** A subscription's remaining, used and total data show two decimals, so 14.65 TB no longer reads as 14.7 TB (65276c5)

## v0.5.3 (2026-11-14)

**Features**

- **profiles** The current profile's menu on the Profiles page opens its details: counts, subscription and external resources (376b12c)
- **l10n** The Windows installer offers Chinese, and the README has a Chinese translation (#153) (6cd2a43)

**Bug Fixes**

- **headers** Dashboard cards you arranged stay put when the subscription updates, unless the panel denies editing them (1d18f35)
- **linux** TUN on Linux reports a Core the Helper refuses instead of failing silently, and AUR packages no longer break the Core's checksum (#156) (7c98452)
- **profiles** Rules added to a profile can target its proxy groups again (#154) (eb61bd8)
- **update** The update reminder's Hide skips only that release, and the download shows its progress in the Download button (9bd0c0d)
- **settings** Picking a language no longer fails when the settings page is rebuilt during the menu's close (ef4eada)
- **linux** An autostarted Linux session waits for the Helper instead of asking to install it again (a4d80c6)
- **windows** Windows PCs whose install date is out of range start again and send their HWID (a4359ea)

**Performance**

- **ui** Glass cards scroll smoother on weak phones (f235adc)
- **android** Android starts smoother on first run (2c34c9e)

## v0.5.2 (2026-11-13)

**Bug Fixes**

- **profiles** Windows devices send the same HWID as in FlClashX 0.4 again, so a device limit no longer counts them twice (8f4ad5c)

## v0.5.1 (2026-11-13)

**Features**

- **dashboard** The wide dashboard on desktop and TV shows the cards flclashx-widgets picks, in its order, and can be edited (4b8b6e4)
- **release** Pre-releases install as a separate FlClashX Pre app and copy the stable app's profiles on first launch (e64104f)
- **profiles** Proxy chains (beta): route a group through two or three hops from the profile's extension page (630903d)
- **dashboard** A hidden outbound IP is left out rather than shown as asterisks, and the dashboard's server name takes over switching the server; Hide IP has its own switch on the Theme page (a12e0a0)
- **update** An update from a provider's mirror installs only when FlClashX signed it, so a mirror cannot hand out another build (fb54dc4)
- **update** Updates can come from a provider's own mirror named in the subscription (4532a8f)
- **update** Updates download inside the app, are checked against the release's checksum and signing identity, and install with one tap (fe8371f)
- **backup** Backups now include the proxy chains of each profile (1a43b3d)
- **proxies** Added rules of a profile can now send traffic through its proxy chains (8085c69)

**Bug Fixes**

- **headers** A panel that stops sending hideip or novibrate shows the IP and turns vibration back on (ea002c5)
- **android** On Android TV, Back from the dashboard keeps the VPN running, and the bundled Zashboard no longer gives way to an old MetaCubeXD (44a0353)
- **profiles** A profile QR code can be read from an image on Windows and Linux again (b1b05cf)
- **proxies** The proxy chains section no longer shows two add buttons while it is empty (bc4a15e)
- **proxies** Switching or applying a profile while it was still loading no longer fails with a disposed-ref error (df81615)

## v0.5.0 (2026-11-12)

**Breaking Changes**

- **profiles** Custom overwrites are removed; rebuild them as custom profiles (c2f57e9)
- **settings** The DNS and NTP override toggles are removed; DNS, NTP, sniffer and TUN are set per key, and picked keys apply to every profile (c2f57e9)
- **tun** Desktop TUN settings follow the profile until you pick them; values you changed carry over (c2f57e9)
- **settings** Settings the subscription sets belong to the provider; each one can be taken over and handed back (c2f57e9)
- **settings** TLS certificates are always checked; the toggle to turn the check off is gone (bb0e6d6)

**Features**

- **core** Built on FlClash 0.9.2 with the mihomo v1.19.34 core (c2f57e9)
- **headers** Subscription headers: flclashx-view, widgets, settings, special, newdomain, service name and logo, serverinfo, buyplan, buytraffic and background (c2f57e9)
- **headers** hideip hides the outbound IP, and app.theme lets the panel set the app theme (c2f57e9)
- **headers** flclashx-override works on the profile's own GLOBAL group (c2f57e9)
- **profiles** Subscription expiry notices; the renewal button appears on its day without waiting for an update (c2f57e9)
- **profiles** External controller and Zashboard from the subscription (c2f57e9)
- **proxies** Group and server descriptions; a group's description shows in place of the node it picked (c2f57e9)
- **settings** The subscription's authentication sets the proxy account (c2f57e9)
- **profiles** App links add a profile without a confirmation and say so (c2f57e9)
- **settings** Every setting the config names (ports, mode, TUN, stack, MTU, congestion control, routes, geo and more) is locked to the provider: a closed lock marks the provider's, an open one yours (c2f57e9)
- **settings** Take any provider setting over and hand it back one at a time; settings the config leaves out stay yours (c2f57e9)
- **settings** Panel header settings apply once per subscription update or profile switch (c2f57e9)
- **settings** strict as a third process-finding mode (c2f57e9)
- **ui** iOS-style interface: stretchy stacked sheets, context menus and slide-to-pick, drag to go back, docked search and long-press reordering (c2f57e9)
- **ui** Sidebar and floating dock; bar buttons lift on hover (c2f57e9)
- **ui** Optional two-tier Liquid Glass with frosted dashboard cards, sheets and setting groups, stepping down for good, and out of the subscription's hands, when the GPU falls behind (c2f57e9)
- **theme** Redesigned theme colors, a higher-contrast dark mode, a refreshed app icon, new glyphs, empty states and theme page (c2f57e9)
- **l10n** French, Spanish and Korean translations, seven languages in all, and a reviewed Russian translation (c2f57e9)
- **dashboard** A redesigned dashboard around the current exit, with more cards and IP quality cached for 3 days (c2f57e9)
- **dashboard** Enhanced view on new installs; movable status card and announcement (c2f57e9)
- **dashboard** Provider logo and name on one row, with the logo cached on disk (c2f57e9)
- **dashboard** Tapping the delay opens the server picker; core restart button, now on Android too (c2f57e9)
- **dashboard** Service checks through the proxy for Gosuslugi, Sberbank, VK, Yandex and Kinopoisk, and outbound IP risk kept off Cloudflare (c2f57e9)
- **proxies** Groups as cards and group tabs as chips (c2f57e9)
- **proxies** Search, mode, test all and fold all in one button group, the rest under More; expand or collapse every group at once (c2f57e9)
- **proxies** Hide timed-out nodes and search every list (c2f57e9)
- **proxies** Add proxies to local proxies; adjustable delay test timeout (c2f57e9)
- **proxies** A profile just added opens on its first group (c2f57e9)
- **profiles** Custom profiles, with include-all in custom groups (c2f57e9)
- **profiles** Profile QR codes and phone-to-TV links (c2f57e9)
- **profiles** Share link import, .mrs rule sets and more proxy fields (c2f57e9)
- **editor** Word wrap and snippets (c2f57e9)
- **config** DNS, NTP, sniffer and TUN set per key; DNS, Hosts and ports apply without a restart; optional general overrides (c2f57e9)
- **config** DNS query log; clear the DNS cache by hand or on a network change (c2f57e9)
- **views** Sortable tables for connections, requests and DNS; recent requests and live connections on one page; punycode hosts shown in Unicode (c2f57e9)
- **core** mihomo v1.19.34: Firefox 148 and Safari 26.3 TLS fingerprints, Snell v6 and several users on a Shadowsocks listener (c2f57e9)
- **core** A crashed desktop Core restarts on its own, at most twice in a row, and names the cause (c2f57e9)
- **android** A rising vibration as the app opens; holding the start/stop button for five seconds toggles the proxy under a rising vibration (c2f57e9)
- **android** Constant 120 Hz; the Core runs in its own process and restarts without restarting the app (c2f57e9)
- **android** The VPN notification shows the service or profile name, optionally with a stop button only (c2f57e9)
- **android** TUN include and exclude packages always apply and override access control; smart selection of Russian apps and a status bar in access control; TUN routes from the subscription (c2f57e9)
- **android** Launcher shortcuts and one-step on-demand access; no Firebase analytics or crash reporting (c2f57e9)
- **android** Share today's logs from the settings (c2f57e9)
- **android** Says why the VPN did not start when its permission is refused, pointing Android 17 users at the Nearby devices permission (c2f57e9)
- **desktop** The first window opens in the phone layout at the top of the screen, so it can always be moved on small screens (c2f57e9)
- **tray** Colored tray status icons with a monochrome option on macOS; tray hotkeys, nodes and a delay test (c2f57e9)
- **app** File logs and app reset; no China presets; disclaimer and About updated; README rewritten with the subscription headers documented on flclashx.app (c2f57e9)
- **migration** Profiles and settings carry over from FlClashX 0.4 on macOS (ebfe1af)
- **proxies** A one-line proxy card size, also set by proxies.card:oneline (ec1fc89)
- **settings** A switch turns vibration off, and a panel can turn it off with novibrate (ea1c50c)
- **ui** An animated GIF or WebP works as the panel background; animated WebP is recommended, being several times smaller than a GIF. It stops on its first frame under reduced motion or when the GPU falls behind (4bd9cbb)

**Bug Fixes**

- **proxies** Updating a subscription no longer switches url-test and fallback groups to a dead first node (c2f57e9)
- **proxies** A node picked while a subscription update applies is no longer lost (c2f57e9)
- **proxies** Load balancers are tested by their nodes, and groups without a URL by the app's test URL, without doubled pings (c2f57e9)
- **profiles** A profile chosen while the app is still starting is no longer ignored, and changes typed during a save are kept (c2f57e9)
- **core** Long-lived connections keep their route; traffic of a UDP session that moved routes is counted on the new route at once (c2f57e9)
- **core** A rule set or geo download past 128 MiB, a malformed .mrs file or a profile with runaway YAML aliases can no longer exhaust memory or freeze the app (c2f57e9)
- **core** Updating the GeoIP or ASN database no longer risks crashing the Core (c2f57e9)
- **backup** A damaged or oversized backup is rejected instead of restored (c2f57e9)
- **android** A VPN start from Quick Settings while the app is starting is no longer lost, and opening the app no longer reloads a running VPN (c2f57e9)
- **android** A start cancelled right before the VPN permission prompt no longer blocks later starts (c2f57e9)
- **android** A stop on an excluded Wi-Fi network keeps the VPN off after leaving it, and VPN settings changed before exiting apply to the next Quick Settings start (c2f57e9)
- **android** Per-app rules on Android 7–9 no longer apply another app's policy to a shared UDP socket (c2f57e9)
- **desktop** Making the window narrow no longer closes an open profile editor or loses its changes (c2f57e9)
- **desktop** A system proxy FlClashX did not set is left alone; it is released while the Core is down and cleared after a crashed or killed run (c2f57e9)
- **tun** A desktop TUN that fails to start is reported and turned off instead of showing as on (c2f57e9)
- **macos** TUN runs through a root-owned copy of the Core outside the app and no longer fails after the password prompt (c2f57e9)
- **macos** The menu bar popover survives a Dock reopen; logout, restart and shutdown are no longer cancelled; launch at login works on macOS 12; tray groups are capped at 100 nodes (c2f57e9)
- **linux** TUN without systemd runs through a per-user copy of the Core and no longer locks other users out; the AppImage starts again (c2f57e9)
- **windows** The Helper and client shut down fully before installing, and a stale system proxy is cleared (c2f57e9)
- **ui** Many fixes to the interface, keyboard and TV remote focus, and to keeping data through downloads, backups and header updates (c2f57e9)
- **android** Any Android APK now installs over any earlier one, whichever ABI variant either is (82fb0a0)
- **android** The VPN follows a move from one Wi-Fi network to another when networks are excluded (2ef7698)
- **linux** The Linux RPM and AppImage start on desktops that have no AppIndicator library installed (802fe79)
- **windows** The Windows installer upgrades a 0.4 install in place instead of installing beside it (61437ab)
- **proxy** The copied proxy variable on Windows works when pasted into PowerShell (9319a55)
- **proxy** Stopping the system proxy on macOS no longer turns off an automatic proxy (PAC) configuration (5b7d97e)
- **migration** An upgrade from 0.4 keeps a rule list that replaced the subscription's rules (a34e9da)
- **migration** An upgrade from 0.4 keeps running the selected script (37af2b9)
- **migration** An upgrade from 0.4 keeps the settings its override switches protected from the subscription (c79eb6c)

**Performance**

- **editor** Smoother editing of large files; a bracket next to the cursor or thousands of same-named share links no longer stall it (c2f57e9)
- **rules** Quick Edit no longer freezes the app on very long rule lists (c2f57e9)
- **android** Smoother UI while the proxy is busy (c2f57e9)

<!-- changelog:frozen -->
<!-- Entries below predate the structured pipeline. Their wording is kept as written; only the heading and list style were normalized. -->

