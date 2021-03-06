package com.mgaetan89.showsrage.presenter;

import com.google.gson.Gson;
import com.mgaetan89.showsrage.model.Schedule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class SchedulePresenterTest {
	@Parameterized.Parameter(1)
	public CharSequence airDate;

	@Parameterized.Parameter(2)
	public String airDateTime;

	@Parameterized.Parameter(3)
	public String airTime;

	@Parameterized.Parameter(4)
	public String airTimeOnly;

	@Parameterized.Parameter(5)
	public int episode;

	@Parameterized.Parameter(6)
	public String network;

	@Parameterized.Parameter(7)
	public String posterUrl;

	@Parameterized.Parameter(8)
	public String quality;

	@Parameterized.Parameter(0)
	public Schedule schedule;

	@Parameterized.Parameter(9)
	public int season;

	@Parameterized.Parameter(10)
	public String showName;

	private SchedulePresenter presenter;

	@Before
	public void before() {
		this.presenter = new SchedulePresenter(this.schedule, null);
	}

	@Test
	public void getAirDate() {
		assertThat(this.presenter.getAirDate()).isEqualTo(this.airDate);
	}

	@Test
	public void getAirTimeOnly() {
		assertThat(this.presenter.getAirTimeOnly()).isEqualTo(this.airTimeOnly);
	}

	@Test
	public void getEpisode() {
		assertThat(this.presenter.getEpisode()).isEqualTo(this.episode);
	}

	@Test
	public void getNetwork() {
		assertThat(this.presenter.getNetwork()).isEqualTo(this.network);
	}

	@Test
	public void getPosterUrl() {
		assertThat(this.presenter.getPosterUrl()).isEqualTo(this.posterUrl);
	}

	@Test
	public void getQuality() {
		assertThat(this.presenter.getQuality()).isEqualTo(this.quality);
	}

	@Test
	public void getSeason() {
		assertThat(this.presenter.getSeason()).isEqualTo(this.season);
	}

	@Test
	public void getShowName() {
		assertThat(this.presenter.getShowName()).isEqualTo(this.showName);
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Gson gson = new Gson();

		return Arrays.asList(new Object[][]{
				{null, null, null, null, null, 0, "", "", "", 0, ""},
				{gson.fromJson("{airdate: null, airs: null, episode: 1, network: null, quality: null, season: 10, show_name: null, tvdbid: 123}", Schedule.class), null, null, null, null, 1, null, "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=123", null, 10, null},
				{gson.fromJson("{airdate: \"\", airs: \"\", episode: 2, network: \"\", quality: \"\", season: 11, show_name: \"\", tvdbid: 456}", Schedule.class), null, null, null, null, 2, "", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=456", "", 11, ""},
				{gson.fromJson("{airdate: \"2015-01-01\", airs: \"Monday 0:00 PM\", episode: 3, network: \"ABC\", quality: \"HD1080p\", season: 12, show_name: \"Show 1\", tvdbid: 789}", Schedule.class), null, null, null, "0:00 PM", 3, "ABC", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "HD1080p", 12, "Show 1"},
				{gson.fromJson("{airdate: \"2015-01-02\", airs: \"monday 1:00 PM\", episode: 4, network: \"CBS\", quality: \"HD\", season: 13, show_name: \"Show 2\", tvdbid: 789}", Schedule.class), null, null, null, "1:00 PM", 4, "CBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "HD", 13, "Show 2"},
				{gson.fromJson("{airdate: \"2015-01-03\", airs: \"Tuesday 2:00 PM\", episode: 5, network: \"TBS\", quality: \"Any\", season: 14, show_name: \"Show 3\", tvdbid: 789}", Schedule.class), null, null, null, "2:00 PM", 5, "TBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "Any", 14, "Show 3"},
				{gson.fromJson("{airdate: \"2015-01-04\", airs: \"tuesday 3:00 PM\", episode: 6, network: \"TBS\", quality: \"Any\", season: 15, show_name: \"Show 4\", tvdbid: 789}", Schedule.class), null, null, null, "3:00 PM", 6, "TBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "Any", 15, "Show 4"},
				{gson.fromJson("{airdate: \"2015-01-05\", airs: \"Wednesday 4:00 PM\", episode: 7, network: \"TBS\", quality: \"Any\", season: 16, show_name: \"Show 5\", tvdbid: 789}", Schedule.class), null, null, null, "4:00 PM", 7, "TBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "Any", 16, "Show 5"},
				{gson.fromJson("{airdate: \"2015-01-06\", airs: \"wednesday 5:00 PM\", episode: 8, network: \"TBS\", quality: \"Any\", season: 17, show_name: \"Show 6\", tvdbid: 789}", Schedule.class), null, null, null, "5:00 PM", 8, "TBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "Any", 17, "Show 6"},
				{gson.fromJson("{airdate: \"2015-01-07\", airs: \"Thursday 6:00 PM\", episode: 9, network: \"TBS\", quality: \"Any\", season: 18, show_name: \"Show 7\", tvdbid: 789}", Schedule.class), null, null, null, "6:00 PM", 9, "TBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "Any", 18, "Show 7"},
				{gson.fromJson("{airdate: \"2015-01-08\", airs: \"thursday 7:00 PM\", episode: 10, network: \"TBS\", quality: \"Any\", season: 19, show_name: \"Show 8\", tvdbid: 789}", Schedule.class), null, null, null, "7:00 PM", 10, "TBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "Any", 19, "Show 8"},
				{gson.fromJson("{airdate: \"2015-01-09\", airs: \"Friday 8:00 PM\", episode: 11, network: \"TBS\", quality: \"Any\", season: 20, show_name: \"Show 9\", tvdbid: 789}", Schedule.class), null, null, null, "8:00 PM", 11, "TBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "Any", 20, "Show 9"},
				{gson.fromJson("{airdate: \"2015-01-10\", airs: \"friday 9:00 PM\", episode: 12, network: \"TBS\", quality: \"Any\", season: 21, show_name: \"Show 10\", tvdbid: 789}", Schedule.class), null, null, null, "9:00 PM", 12, "TBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "Any", 21, "Show 10"},
				{gson.fromJson("{airdate: \"2015-01-11\", airs: \"Saturday 10:00 PM\", episode: 13, network: \"TBS\", quality: \"Any\", season: 22, show_name: \"Show 11\", tvdbid: 789}", Schedule.class), null, null, null, "10:00 PM", 13, "TBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "Any", 22, "Show 11"},
				{gson.fromJson("{airdate: \"2015-01-12\", airs: \"saturday 11:00 PM\", episode: 14, network: \"TBS\", quality: \"Any\", season: 23, show_name: \"Show 12\", tvdbid: 789}", Schedule.class), null, null, null, "11:00 PM", 14, "TBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "Any", 23, "Show 12"},
				{gson.fromJson("{airdate: \"2015-01-13\", airs: \"Sunday 0:00 PM\", episode: 15, network: \"TBS\", quality: \"Any\", season: 24, show_name: \"Show 13\", tvdbid: 789}", Schedule.class), null, null, null, "0:00 PM", 15, "TBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "Any", 24, "Show 13"},
				{gson.fromJson("{airdate: \"2015-01-14\", airs: \"sunday 1:00 PM\", episode: 16, network: \"TBS\", quality: \"Any\", season: 25, show_name: \"Show 14\", tvdbid: 789}", Schedule.class), null, null, null, "1:00 PM", 16, "TBS", "https://127.0.0.1:8083/api/apiKey/?cmd=show.getposter&tvdbid=789", "Any", 25, "Show 14"},
		});
	}
}
