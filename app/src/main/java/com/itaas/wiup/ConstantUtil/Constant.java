package com.itaas.wiup.ConstantUtil;

import com.itaas.wiup.InterfaceUtil.LocationCallback;
import com.itaas.wiup.ObjectUtil.UniversalVariable;
import com.itaas.wiup.R;
import com.mapbox.api.directions.v5.models.DirectionsRoute;

/**
 * Created by hp on 5/20/2018.
 */

public class Constant {

    static Double latitude;
    static Double longitude;
    static String cityName;
    static String weather;
    static DirectionsRoute directionsRoute;
    static UniversalVariable universalVariable;
    static LocationCallback locationCallback;


    public static enum REQUEST {NEARBY, DIRECTION, TOP_PLACES, PLACE_DETAIL, WIKI, NEARBY_PLACES_ONLY, SNAP_TO_ROAD}

    public static enum EVENTS {FEATURE_PLACE, PLACE}

    public static enum DATABASE_EVENT {INSERT, RETRIEVE, DELETE, SINGLE}

    public static enum DATABASE_FUNCTION {FAVOURITE, HISTORY}

    public static enum FRAGMENT_TYPE {HOME, FAVOURITES, HISTORY, SETTING}

    public static enum LOCATION_SELECTOR {SOURCE_LOCATION, DESTINATION_LOCATION}

    public static enum SHARED_PREF {REMOVE_AD, AR_NAV, HUD_VIEW, COVERAGE}


    /**
     * <p>It contain all Server Url</p>
     */
    public static class ServerInformation {

        public static String NEARBY_PLACES_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&type=%s&key=" + Credentials.GOOGLE_API_KEY;
        public static String NEARBY_PLACES_KEYWORD_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&type=%s&key=" + Credentials.GOOGLE_API_KEY + "&pagetoken=%s";
        public static String NEARBY_PLACES_URL_FOR_NEARBY = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%s&key=" + Credentials.GOOGLE_API_KEY;
        public static String GOOGLE_DRIVE_LINK = "https://docs.google.com/uc?id=";
        public static String GOOGLE_MAP_PHOTO_REFERENCES = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=300&photoreference=%s&key=" + Credentials.GOOGLE_API_KEY_PHOTO;
        public static String PLACE_DETAIL_URL = "https://maps.googleapis.com/maps/api/place/details/json?placeid=%s&key=" + Credentials.GOOGLE_API_KEY;
        public static String TOP_PLACES = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=%s&key=" + Credentials.GOOGLE_API_KEY_TOP_PLACES;
        public static String TOP_PLACES_NEXT_TOKEN = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=%s&key=" + Credentials.GOOGLE_API_KEY_TOP_PLACES + "&pagetoken=%s";
        public static String WIKI_API_LINK = "https://en.wikipedia.org/w/api.php?format=json&action=query&list=geosearch&gscoord=%s%s%s&gsradius=10000&gslimit=40";
        public static String WIKIPEDIA_LINK = "http://en.wikipedia.org/?curid=%s";
        public static String googleLink = "http://maps.google.com/maps?q=%s,%s&ll=%s,%s&z=17";
        public static String googleMapLink = "https://www.google.com/maps/dir/?api=1&travelmode=driving&dir_action=navigate&destination=%s";

    }


    /**
     * <p>It contain list of place holder icons</p>
     */
    public static class PlaceHolder {
        public static int place_holder = R.drawable.place_holder_icon;
    }


    /**
     * <p>It contain all of the API keys from different Services</p>
     */
    public static class Credentials {
        public static String GOOGLE_API_KEY = "AIzaSyBFfNh8-qCSYRqg-EDgk6STGuL7e5jP5MQ";
        public static String GOOGLE_API_KEY_PHOTO = "AIzaSyBFfNh8-qCSYRqg-EDgk6STGuL7e5jP5MQ";
        public static String GOOGLE_API_KEY_TOP_PLACES = "AIzaSyBbe4LblrUnP-a6Yjgl7ayKnLS4ockYTOE";
        public static String GOOGLE_SERVER_KEY = "AIzaSyBbe4LblrUnP-a6Yjgl7ayKnLS4ockYTOE";

        public static String ADMOB_TEST_DEVICE_ID = "ADMOB_TEST_DEVICE_ID";
        public static String ADMOB_APP_ID = "ADMOB_APP_ID";
        public static String ADMOB_INTERSTITIAL_ID = "ADMOB_INTERSTITIAL_ID";

        public static String DARK_SKY_API_KEY = "df4c27f9b45c6b9eeced69b18867a3f1";
        public static String MAP_BOX_API_KEY = "pk.eyJ1IjoiaXRhYXMiLCJhIjoiY2sxdjhmNDBrMGVlOTNjcDU5aGVsczBoaSJ9.fKp0EYFBgmCjqNUj6XY6vg";
        public static String UBER_CLIENT_ID = "q6PP3T9GIsNmWrGlSyXimbgebcOpXGeV";
        public static String UBER_CLIENT_SECRET = "5QDPrTnO0M0-OPXUQyR8a_Nw5OQrMRgXvo9WA8DJ";
        public static String UBER_SERVER_TOKEN = "JA.VUNmGAAAAAAAEgASAAAABwAIAAwAAAAAAAAAEgAAAAAAAAH4AAAAFAAAAAAADgAQAAQAAAAIAAwAAAAOAAAAzAAAABwAAAAEAAAAEAAAANaWi9mgkqVCxeVNV2vGdiSnAAAABADDZrgRKNolqOBnJu22bX2unppcyRL7jxQzpfvttF7pdA_U1p9_tOsWNHbi57iZb6Z-wUMoUigFK3uGvBaDJyadXuS_js-VHp4Yx6Ct1LeIm2ap5QceLBPeIFh57U0rrYBOB3cUvNd6sP4THWy6ngw0k_uAW4tU4x2eqnTLZJPLFQwkEtqFyL18_NCMHzIibbX-vxonzWM95hiF4oDJnFpVQP2WsgcADAAAAGqU0i_x-pkOgJPc4iQAAABiMGQ4NTgwMy0zOGEwLTQyYjMtODA2ZS03YTRjZjhlMTk2ZWU";


    }


    /**
     * <p>It contain all of the Important Messages</p>
     */
    public static class ImportantMessages {
        public static final String CONNECTION_ERROR = "Error de conexión";
        public static String top = "Mejores";
        public static String place = "Lugares";
        public static String restaurant = "Restaurantes";
        public static String thing = "Cosas";
        public static String ToDo = "Que hacer";
        public static String briefly = "Brevemente";
        public static String explore = "Explore la ciudad";
        public static String nearest = "Más cercano";
        public static String more = "Más";
        public static String nearby_places = "Lugares mas cercanos";
        public static String loading = "Cargando";
        public static String place_detail = "Historia del lugar";
        public static String top_place = "Cargando lugares";
        public static String miles = "Km";
        public static String nearby = "Lejos";
        public static String no_review = "No hay revisión disponible";
        public static String price_level_label = "Nivel de precios";
        public static String litre_label = "Litro";
        public static String car_label = "Carro";
        public static String bicycle_label = "Bicicleta";
        public static String walk_label = "Para caminar";
        public static String no_favourite = "No hay favoritos";
        public static String no_favourite_tagline = "No has marcado nada hasta ahora\n" +
                "Marque sus lugares favoritos";
        public static String no_history = "Ninguna ubicación";
        public static String no_history_tagline = "No viajaste a ningún lado hasta ahora\n" +
                " ¡Comienza a viajar ahora!";
        public static String celcius_symbol = "\u00b0C";
        public static String LOADING_WEATHER = "¡Cargando!";
        public static String wiki_loading = "Cargando Wikipedia";
    }


    /**
     * <p>It contain all of the Toast messages</p>
     */
    public static class ToastMessage {
        public static String NO_INTERNET_MESSAGE = "Sin conexión a Internet";
        public static String EMPTY_BOX = "Escribe amablemente cualquier palabra";
        public static String NO_DATA = "Sin resultados";
        public static String LOCATION_FROM_HISTORY = "";
        public static String SELECT_DESTINATION = "Primero, selecciona el destinon";
        public static String WEATHER_ERROR = "Hay un error al recuperar el Informe del tiempo";
        public static String TURN_ON_AR = "Active la navegación aumentada desde la configuración";
        public static String TURN_ON_GPS = "Encienda el GPS primero";
        public static String CAMERA_REQUIRE_PERMISSION = "No permitiste el permiso de la cámara";
        public static String EXTERNAL_REQUIRE_PERMISSION = "No permitiste la autorización de la tarjeta SD";
        public static String LOCATION_REQUIRE_PERMISSION = "No permitiste el permiso de ubicación";
        public static String RES_START_APP = "Reinicie la aplicación, hay un problema en la aplicación";
        public static String DID_NOT_SUPPORT_VERSION = "La realidad aumentada no era compatible con la versión inferior de Lollipop";
        public static String DID_NOT_HAVE_COMPASS = "No tenía la función Brújula";
    }


    /**
     * <p>It contain all of the Menu labels</p>
     */
    public static class MenuText {
        public static String HOME_MENU_TEXT = "Diccionario";
        public static String PLACE_DETAIL_TEXT = "Detalle del lugar";
        public static String REVIEW_TEXT = "Lista de comentarios";
        public static String HOME_TEXT = "Inicio";
        public static String FAVOURITE_TEXT = "Favoritos";
        public static String HISTORY_TEXT = "Historial";
        public static String AR_NAVIGATION_TEXT = "Ar Navegación";
        public static String AR_POI_BROWSER = "Ar Navegador Poi";
        public static String SETTING_TEXT = "Ajuste";
        public static String TOURISM_TEXT = "Turismo";
        public static String PLACES_NEAR_YOU = "Lugares cercanos";
        public static String ROUTES = "Ruta y Direcciones";
        public static String NAVIGATION = "Navegaciónn";
        public static String LIST_OF_PLACES = "Lista de lugares";
        public static String FROM_LABEL = "Desde";
        public static String TO_LABEL = "A";
            public static String DISTANCE_LABEL = "Distancia";
        public static String TIME_LABEL = "Duración";
        public static String PETROL_LABEL = "Gasolina";
        public static String NAVIGATION_LABEL = "Iniciar navegación";
        public static String ROUTE_LABEL = "Ruta";
        public static String TRIP_PLANING = "Planifica tu viaje";
        public static String NEARBY_WIKI = "Enciclopedia cercana";
        public static String TOP_PLACES = "Mejores lugares";
    }


    /**
     * <p>It contain all of the Key of Share Preferences</p>
     */
    public static class SharedPref {
        public static String PREF_NAME = "Data";
        public static String REMOVE_AD = "REMOVE_AD";
        public static String AR_NAV = "AR_NAV";
        public static String HUD_VIEW = "HUD_VIEW";
        public static String COVERAGE = "COVERAGE";
    }


    /**
     * <p>It contain all of the Request Code</p>
     */
    public static class RequestCode {
        public static int LOCATION_REQUEST_CODE = 1;
        public final static int REQUEST_LOCATION = 2;
        public static int PLACE_AUTOCOMPLETE_REQUEST_CODE_SOURCE = 3;
        public static int PLACE_AUTOCOMPLETE_REQUEST_CODE_DEST = 4;
        public static int SEARCH_SPECIFIC_PLACE = 5;
    }


    /**
     * <p>It contain all of the Key of Share Preferences</p>
     */
    public static class IntentKey {
        public static final String IS_TOURIST = "IS_TOURIST";
        public static String PLACE_DETAIL = "PLACE_DETAIL";
        public static String PLACE_RATING = "PLACE_RATING";
        public static String PLACE_REQUIRED = "PLACE_REQUIRED";
        public static String DESTINATION_LONGITUDE = "DESTINATION_LONGITUDE";
        public static String DESTINATION_LATITUDE = "DESTINATION_LATITUDE";
        public static String NAVIGATION_DETAIL = "NAVIGATION_DETAIL";
        public static String DESTINATION_NAME = "DESTINATION_NAME";
        public static String HISTORY_LOCATION = "HISTORY_LOCATION";
        public static String SOURCE_LONGITUDE = "SOURCE_LONGITUDE";
        public static String SOURCE_LATITUDE = "SOURCE_LATITUDE";
        public static String CONVEYANCE = "CONVEYANCE";
        public static String AR_DIRECTION = "AR_DIRECTION";
        public static String IS_SEARCHED_PLACE = "IS_SEARCHED_PLACE";
        public static String SEARCH_PLACE_ID = "SEARCH_PLACE_ID";
        public static String DISTANCE = "DISTANCE";
        public static String DURATION = "DURATION";
        public static String DRIVING_PROFILE = "DRIVING_PROFILE";
    }


    /**
     * <p>It contain all of the database columns</p>
     */
    public static class DatabaseColumn {
        public static final String TAG = "Database";
        public static String TABLE_NAME = "Favourites";
        public static String ID_COLUMN = "id";
        public static String PLACE_ID = "place_id";
        public static String PLACE_PICTURE = "place_picture";
        public static String PLACE_NAME = "place_name";
        public static String PRICE_LEVEL = "price_level";
        public static String PLACE_RATING = "place_rating";
        public static String PLACE_TYPE = "place_type";
        public static String PLACE_ADDRESS = "place_address";
        public static String PLACE_LATITUDE = "place_latitude";
        public static String PLACE_LONGITUDE = "place_longitude";

        public static String HISTORY_TABLE_NAME = "History";
        public static String HISTORY_ID_COLUMN = "id";
        public static String SOURCE_NAME_COLUMN = "source";
        public static String DESTINATION_NAME_COLUMN = "destination";
        public static String SOURCE_LATITUDE_COLUMN = "source_latitude";
        public static String SOURCE_LONGITUDE_COLUMN = "source_longitude";
        public static String DESTINATION_LATITUDE_COLUMN = "destination_latitude";
        public static String DESTINATION_LONGITUDE_COLUMN = "destination_longitude";
        public static String DISTANCE_COLUMN = "distance";
        public static String DURATION_COLUMN = "duration";
        public static String PETROL_COLUMN = "petrol";
        public static String BY_COLUMN = "conveyance";
        public static String ROUTE_COLUMN = "route";

    }


    /**
     * <p>Contain list of Locations along with their tags which is used
     * while sending request to Google server when requesting nearbny
     * places</p>
     */
    public static class LocationTypes {
        public String ACCOUNTING = "contabilidad";
        public String AIRPORT = "aeropuerto";
        public String AMUSEMENT_PARK = "parque_de_atracciones";
        public String AQUARIUM = "acuario";
        public String ART_GALLERY = "galería_de_arte";
        public String ATM = "atm";
        public String BAKERY = "panadería";
        public String BANK = "banco";
        public String BAR = "bar";
        public String BEAUTY_SALON = "salon_de_belleza";
        public String BICYCLE_STORE = "tienda_bicicletas";
        public String BOOK_STORE = "librería";
        public String BOWLING_ALLEY = "bolera";
        public String BUS_STATION = "estación_de_autobuses";
        public String CAFE = "cafe";
        public String CAMPGROUND = "terreno_de_camping";
        public String CAR_DEALER = "vendedor_de_autos";
        public String CAR_RENTAL = "alquiler_de_coches";
        public String CAR_REPAIR = "reparación_de_autos";
        public String CAR_WASH = "lavado de autos";
        public String CASINO = "casino";
        public String CEMETERY = "cementerio";
        public String CITY_HALL = "Palacio_Municipal";
        public String CLOTHING_STORE = "tienda_de_ropa";
        public String CONVENIENCE_STORE = "tienda_de_conveniencia";
        public String COURTHOUSE = "palacio_de_justicia";
        public String DENTIST = "dentista";
        public String DEPARTMENT_STORE = "department_store";
        public String DOCTOR = "doctor";
        public String ELECTRICIAN = "electrician";
        public String ELECTRONICS_STORE = "electronics_store";
        public String EMBASSY = "embassy";
        public String FINANCE = "finance";
        public String FIRE_STATION = "fire_station";
        public String FLORIST = "florist";
        public String FUNERAL_HOME = "funeral_home";
        public String FURNITURE_STORE = "furniture_store";
        public String GAS_STATION = "gas_station";
        public String GYM = "gym";
        public String HAIR_CARE = "hair_care";
        public String HARDWARE_STORE = "hardware_store";
        public String HOME_GOODS_STORE = "home_goods_store";
        public String HOSPITAL = "hospital";
        public String INSURANCE_AGENCY = "insurance_agency";
        public String JEWELRY_STORE = "jewelry_store";
        public String LAUNDRY = "laundry";
        public String LAWYER = "lawyer";
        public String LIBRARY = "library";
        public String LIQUOR_STORE = "liquor_store";
        public String LOCAL_GOVERNMENT_OFFICE = "local_government_office";
        public String LOCKSMITH = "locksmith";
        public String LODGING = "lodging";
        public String MEAL_DELIVERY = "meal_delivery";
        public String MEAL_TAKEAWAY = "meal_takeaway";
        public String MOSQUE = "mosque";
        public String MOVIE_RENTAL = "movie_rental";
        public String MOVIE_THEATER = "movie_theater";
        public String MOVING_COMPANY = "moving_company";
        public String MUSEUM = "museum";
        public String NIGHT_CLUB = "night_club";
        public String PAINTER = "painter";
        public String PARK = "park";
        public String PARKING = "parking";
        public String PET_STORE = "pet_store";
        public String PHARMACY = "pharmacy";
        public String PHYSIOTHERAPIST = "physiotherapist";
        public String PLUMBER = "plumber";
        public String POLICE = "police";
        public String POST_OFFICE = "post_office";
        public String REAL_ESTATE_AGENCY = "real_estate_agency";
        public String RESTAURANT = "restaurant";
        public String ROOFING_CONTRACTOR = "roofing_contractor";
        public String RV_PARK = "rv_park";
        public String SCHOOL = "school";
        public String SHOE_STORE = "shoe_store";
        public String SHOPPING_MALL = "shopping_mall";
        public String SPA = "spa";
        public String STADIUM = "stadium";
        public String STORAGE = "storage";
        public String STORE = "store";
        public String SUBWAY_STATION = "subway_station";
        public String SYNAGOGUE = "synagogue";
        public String TAXI_STAND = "taxi_stand";
        public String TRAIN_STATION = "train_station";
        public String TRANSIT_STATION = "transit_station";
        public String TRAVEL_AGENCY = "travel_agency";
        public String UNIVERSITY = "university";
        public String VETERINARY_CARE = "veterinary_care";
        public String ZOO = "zoo";


    }


    public static Double getLatitude() {
        return latitude;
    }

    public static void setLatitude(Double latitude) {
        Constant.latitude = latitude;
    }

    public static Double getLongitude() {
        return longitude;
    }

    public static void setLongitude(Double longitude) {
        Constant.longitude = longitude;
    }

    public static String getCityName() {
        return cityName;
    }

    public static void setCityName(String cityName) {
        Constant.cityName = cityName;
    }

    public static DirectionsRoute getDirectionsRoute() {
        return directionsRoute;
    }

    public static void setDirectionsRoute(DirectionsRoute directionsRoute) {
        Constant.directionsRoute = directionsRoute;
    }

    public static UniversalVariable getUniversalVariable() {
        return universalVariable;
    }

    public static void setUniversalVariable(UniversalVariable universalVariable) {
        Constant.universalVariable = universalVariable;
    }

    public static LocationCallback getLocationCallback() {
        return locationCallback;
    }

    public static void setLocationCallback(LocationCallback locationCallback) {
        Constant.locationCallback = locationCallback;
    }

    public static String getWeather() {
        return weather;
    }

    public static void setWeather(String weather) {
        Constant.weather = weather;
    }


}
