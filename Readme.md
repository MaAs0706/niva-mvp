# Niva — MVP (Session-Based Safety App)

## Status
MVP development starts today.  
Deadline for first working build: December 29, 2025.  
Founder: Aswanth Madhav

## What the MVP Will Do
- Session-based safety (manual + geofence-triggered)
- Background location tracking
- Inactivity detection
- “Are you OK?” discreet check-in prompt
- Auto-escalation via SMS intent
- Privacy-first local processing

## Tech Stack
- Android (Kotlin)
- Firebase (Auth, Firestore, FCM)
- Google Maps SDK + Fused Location Provider
- Foreground Services + Geofencing

## Milestones
### Week 1 (Dec 1–7)
- Firebase setup
- Project skeleton
- Contacts screen
- Foreground service base
- Geofence registration

### Week 2 (Dec 8–14)
- Location updates
- Route polyline
- Deviation detection

### Week 3 (Dec 15–21)
- Inactivity → check-in logic
- Notification flow
- Escalation SMS intent

### Week 4 (Dec 22–29)
- Privacy onboarding
- Internal testing (5 testers)
- MVP ready for beta

## Vision
Niva is a proactive, hands-free safety companion that helps users during commutes by detecting unusual behaviour and escalating only when necessary.

## License
MIT
