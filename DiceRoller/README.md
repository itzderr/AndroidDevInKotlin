# Notes

### Vector drawables
- "re-drawable graphic"
- vector is smaller than bitmap images (size), also scalable without losing quality
- vector is supported from API 21 ~, but our minSDK = API 19
- "Android Support Library (androidx - JetPack 2018)"
- In your `activity_main.xml`, add `xmlns:app="http://schemas.android.com/apk/res-auto"`
- Use `app:srcCompat` from the support library (instead of `android:src`)
