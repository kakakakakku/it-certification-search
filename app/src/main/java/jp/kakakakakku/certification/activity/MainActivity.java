package jp.kakakakakku.certification.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.kakakakakku.certification.R;
import jp.kakakakakku.certification.async.SkeletonAsync;
import jp.kakakakakku.certification.callback.Callback;
import jp.kakakakakku.certification.db.entity.CertificationEntity;

public class MainActivity extends Activity {

    // TODO: 外部データ化しないと管理しきれない感じがする
    // TODO: IBM関連資格を追加
    private static final List<CertificationEntity> cList = Arrays.asList(
            new CertificationEntity("ITパスポート試験", "IPA", "一般", 5100, "http://www.jitec.ipa.go.jp/", "一般"),
            new CertificationEntity("基本情報技術者試験", "IPA", "一般", 5100, "http://www.jitec.ipa.go.jp/", "一般"),
            new CertificationEntity("応用情報技術者試験", "IPA", "一般", 5100, "http://www.jitec.ipa.go.jp/", "一般"),
            new CertificationEntity("ITストラテジスト試験", "IPA", "一般", 5100, "http://www.jitec.ipa.go.jp/", "一般"),
            new CertificationEntity("システムアーキテクト試験", "IPA", "一般", 5100, "http://www.jitec.ipa.go.jp/", "一般"),
            new CertificationEntity("プロジェクトマネージャ試験", "IPA", "一般", 5100, "http://www.jitec.ipa.go.jp/", "一般"),
            new CertificationEntity("ネットワークスペシャリスト試験", "IPA", "ネットワーク", 5100, "http://www.jitec.ipa.go.jp/", "ネットワーク"),
            new CertificationEntity("データベーススペシャリスト試験", "IPA", "データベース", 5100, "http://www.jitec.ipa.go.jp/", "データベース"),
            new CertificationEntity("エンベデッドシステムスペシャリスト試験", "IPA", "組込み", 5100, "http://www.jitec.ipa.go.jp/", "組込み"),
            new CertificationEntity("情報セキュリティスペシャリスト試験", "IPA", "セキュリティ", 5100, "http://www.jitec.ipa.go.jp/", "セキュリティ"),
            new CertificationEntity("ITサービスマネージャ試験", "IPA", "一般", 5100, "http://www.jitec.ipa.go.jp/", "一般"),
            new CertificationEntity("システム監査技術者試験", "IPA", "一般", 5100, "http://www.jitec.ipa.go.jp/", "一般"),
            new CertificationEntity("Ruby Association Certified Ruby Programmer Silver", "Rubyアソシエーション", "プログラミング", 15000, "http://www.ruby.or.jp/ja/certification/", "Ruby"),
            new CertificationEntity("Ruby Association Certified Ruby Programmer Gold", "Rubyアソシエーション", "プログラミング", 15000, "http://www.ruby.or.jp/ja/certification/", "Ruby"),
            new CertificationEntity("Rails3技術者認定ブロンズ試験", "Rails技術者認定試験運営委員会", "プログラミング", 10000, "http://www.railscp.org/", "Ruby / Rails"),
            new CertificationEntity("Rails4技術者認定シルバー試験", "Rails技術者認定試験運営委員会", "プログラミング", 0, "http://www.railscp.org/", "Ruby / Rails"),
            new CertificationEntity("Rails4技術者認定ゴールド・デベロッパー", "Rails技術者認定試験運営委員会", "プログラミング", 0, "http://www.railscp.org/", "Ruby / Rails"),
            new CertificationEntity(".com Master BASIC", "NTTコミュニケーションズ", "ネットワーク", 4000, "http://www.com-master.jp/", "ネットワーク"),
            new CertificationEntity(".com Master ADVANCE", "NTTコミュニケーションズ", "ネットワーク", 8000, "http://www.com-master.jp/", "ネットワーク"),
            new CertificationEntity("XMLマスター：ベーシック", "XML技術者育成推進委員会", "マークアップ", 0, "http://www.xmlmaster.org/", "XML"),
            new CertificationEntity("XMLマスター：プロフェッショナル（アプリケーション開発）", "XML技術者育成推進委員会", "マークアップ", 0, "http://www.xmlmaster.org/", "XML"),
            new CertificationEntity("XMLマスター：プロフェッショナル（データベース）", "XML技術者育成推進委員会", "マークアップ", 0, "http://www.xmlmaster.org/", "XML"),
            new CertificationEntity("情報処理技術者能力認定試験 1級", "株式会社サーティファイ", "一般", 5000, "http://www.sikaku.gr.jp/", "一般"),
            new CertificationEntity("情報処理技術者能力認定試験 2級", "株式会社サーティファイ", "一般", 5600, "http://www.sikaku.gr.jp/", "一般"),
            new CertificationEntity("情報処理技術者能力認定試験 3級", "株式会社サーティファイ", "一般", 6300, "http://www.sikaku.gr.jp/", "一般"),
            new CertificationEntity("C言語プログラミング能力認定試験 1級", "株式会社サーティファイ", "プログラミング", 5000, "http://www.sikaku.gr.jp/", "C"),
            new CertificationEntity("C言語プログラミング能力認定試験 2級", "株式会社サーティファイ", "プログラミング", 6100, "http://www.sikaku.gr.jp/", "C"),
            new CertificationEntity("C言語プログラミング能力認定試験 3級", "株式会社サーティファイ", "プログラミング", 5000, "http://www.sikaku.gr.jp/", "C"),
            new CertificationEntity("Java™プログラミング能力認定試験 1級", "株式会社サーティファイ", "プログラミング", 5000, "http://www.sikaku.gr.jp/", "Java"),
            new CertificationEntity("Java™プログラミング能力認定試験 2級", "株式会社サーティファイ", "プログラミング", 6100, "http://www.sikaku.gr.jp/", "Java"),
            new CertificationEntity("Java™プログラミング能力認定試験 3級", "株式会社サーティファイ", "プログラミング", 7400, "http://www.sikaku.gr.jp/", "Java"),
            new CertificationEntity("ワードプロセッサ技能認定試験 1級", "株式会社サーティファイ", "一般", 4200, "http://www.sikaku.gr.jp/", "一般"),
            new CertificationEntity("ワードプロセッサ技能認定試験 2級", "株式会社サーティファイ", "一般", 4900, "http://www.sikaku.gr.jp/", "一般"),
            new CertificationEntity("ワードプロセッサ技能認定試験 3級", "株式会社サーティファイ", "一般", 6000, "http://www.sikaku.gr.jp/", "一般"),
            new CertificationEntity("ワードプロセッサ技能認定試験 4級", "株式会社サーティファイ", "一般", 7100, "http://www.sikaku.gr.jp/", "一般"),
            new CertificationEntity("LPI Level1 Exam 101/102", "LPI-Japan", "サーバー", 30000, "http://www.lpi.or.jp/", "Linux"),
            new CertificationEntity("LPI Level2 Exam 201/202", "LPI-Japan", "サーバー", 30000, "http://www.lpi.or.jp/", "Linux"),
            new CertificationEntity("LPI 300 Mixed Environment Exam", "LPI-Japan", "サーバー", 30000, "http://www.lpi.or.jp/", "Linux"),
            new CertificationEntity("LPI 301 Core Exam", "LPI-Japan", "サーバー", 30000, "http://www.lpi.or.jp/", "Linux"),
            new CertificationEntity("LPI 302 Mixed Environment Exam", "LPI-Japan", "サーバー", 21000, "http://www.lpi.or.jp/", "Linux"),
            new CertificationEntity("LPI 303 Security Exam", "LPI-Japan", "サーバー", 30000, "http://www.lpi.or.jp/", "Linux"),
            new CertificationEntity("LPI 304 Virtualization & High Availability Exam", "LPI-Japan", "サーバー", 30000, "http://www.lpi.or.jp/", "Linux"),
            new CertificationEntity("Cloudera Apache Hadoop 認定開発者 (CCDH)", "Cloudera", "ビッグデータ", 0, "http://www.cloudera.co.jp/university/", "Hadoop"),
            new CertificationEntity("Cloudera Apache Hadoop 認定管理者 (CCAH)", "Cloudera", "ビッグデータ", 0, "http://www.cloudera.co.jp/university/", "Hadoop"),
            new CertificationEntity("Cloudera Apache HBase 認定スペシャリスト (CCSHB)", "Cloudera", "ビッグデータ", 0, "http://www.cloudera.co.jp/university/", "Hadoop / HBase"),
            new CertificationEntity("Cloudera 認定プロフェッショナル：データサイエンティスト（CCP:DS）", "Cloudera", "ビッグデータ", 0, "http://www.cloudera.co.jp/university/", ""),
            new CertificationEntity("HTML5プロフェッショナル認定資格 レベル1 (Markup Professional)", "LPI-Japan", "マークアップ", 15000, "http://html5exam.jp/", "HTML / CSS / JavaScript"),
            new CertificationEntity("HTML5プロフェッショナル認定資格 レベル2 (Application Development Professional)", "LPI-Japan", "マークアップ", 15000, "http://html5exam.jp/", "HTML / CSS / JavaScript"),
            new CertificationEntity("Android™アプリケーション技術者認定試験ベーシック", "OESF", "ネイティブ", 0, "http://oesf-edu.com/", "Android / Java"),
            new CertificationEntity("Android™プラットホーム技術者認定試験ベーシック", "OESF", "ネイティブ", 0, "http://oesf-edu.com/", "Android / Java"),
            new CertificationEntity("オープンソースデータベース技術者認定資格 Silver", "LPI-Japan", "データベース", 15000, "http://www.oss-db.jp/", "PostgreSQL"),
            new CertificationEntity("オープンソースデータベース技術者認定資格 Gold", "LPI-Japan", "データベース", 15000, "http://www.oss-db.jp/", "PostgreSQL"),
            new CertificationEntity("VMware Certified Associate - Data Center Virtualization", "VMware", "仮想化", 9975, "http://info.vmware.com/content/apac_jp_co_education-certification", "仮想化"),
            new CertificationEntity("VMware Certified Associate - Workforce Mobility", "VMware", "仮想化", 9975, "http://info.vmware.com/content/apac_jp_co_education-certification", "仮想化"),
            new CertificationEntity("VMware Certified Associate – Cloud", "VMware", "仮想化", 9975, "http://info.vmware.com/content/apac_jp_co_education-certification", "仮想化"),
            new CertificationEntity("VMware Certified Professional 5 – Data Center Virtualization", "VMware", "仮想化", 18700, "http://info.vmware.com/content/apac_jp_co_education-certification", "仮想化"),
            new CertificationEntity("VMware Certified Professional 5 - Desktop", "VMware", "仮想化", 18700, "http://info.vmware.com/content/apac_jp_co_education-certification", "仮想化"),
            new CertificationEntity("VMware Certified Professional – Cloud", "VMware", "仮想化", 18700, "http://info.vmware.com/content/apac_jp_co_education-certification", "仮想化"),
            new CertificationEntity("VMware Certified Advanced Professional 5 - Data Center Administration", "VMware", "仮想化", 0, "http://info.vmware.com/content/apac_jp_co_education-certification", "仮想化"),
            new CertificationEntity("VMware Certified Advanced Professional 5 - Data Center Design", "VMware", "仮想化", 0, "http://info.vmware.com/content/apac_jp_co_education-certification", "仮想化"),
            new CertificationEntity("VMware Certified Advanced Professional - Desktop Design", "VMware", "仮想化", 0, "http://info.vmware.com/content/apac_jp_co_education-certification", "仮想化"),
            new CertificationEntity("VMware Certified Advanced Professional – Cloud Infrastructure Design", "VMware", "仮想化", 0, "http://info.vmware.com/content/apac_jp_co_education-certification", "仮想化"),
            new CertificationEntity("VMware Certified Advanced Professional – Cloud Infrastructure Administration", "VMware", "仮想化", 0, "http://info.vmware.com/content/apac_jp_co_education-certification", "仮想化"),
            new CertificationEntity("PHP5技術者認定初級試験", "PHP技術者認定機構", "プログラミング", 12000, "http://www.phpexam.jp/", "PHP"),
            new CertificationEntity("PHP5技術者認定上級試験", "PHP技術者認定機構", "プログラミング", 15000, "http://www.phpexam.jp/", "PHP"),
            new CertificationEntity("PHP5技術者認定ウィザード", "PHP技術者認定機構", "プログラミング", 0, "http://www.phpexam.jp/", "PHP"),
            new CertificationEntity("JSTQB認定テスト技術者資格 Foundation Level", "JSTQB", "テスト", 21600, "http://jstqb.jp/", "システム開発 / 品質管理 / テスティングフレームワーク"),
            new CertificationEntity("JSTQB認定テスト技術者資格 Advanced Level", "JSTQB", "テスト", 21600, "http://jstqb.jp/", "システム開発 / 品質管理 / テスティングフレームワーク"),
            new CertificationEntity("JP1認定セールスコーディネーター", "日立製作所", "システム管理", 5000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定エンジニア", "日立製作所", "システム管理", 6000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定プロフェッショナル 統合管理", "日立製作所", "システム管理", 8000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定プロフェッショナル アベイラビリティ管理", "日立製作所", "システム管理", 8000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定プロフェッショナル ジョブ管理", "日立製作所", "システム管理", 8000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定プロフェッショナル 資産・配布管理", "日立製作所", "システム管理", 8000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定プロフェッショナル ネットワーク管理", "日立製作所", "システム管理", 8000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定プロフェッショナル ストレージ管理－バックアップ管理－", "日立製作所", "システム管理", 8000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html",  "JP1"),
            new CertificationEntity("JP1認定プロフェッショナル セキュリティ管理－情報漏えい防止－", "日立製作所", "システム管理", 8000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定コンサルタント 統合管理", "日立製作所", "システム管理", 10000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定コンサルタント アベイラビリティ管理", "日立製作所", "システム管理", 10000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定コンサルタント ジョブ管理", "日立製作所", "システム管理", 10000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定コンサルタント 資産・配布管理", "日立製作所", "システム管理", 10000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定コンサルタント ネットワーク管理", "日立製作所", "システム管理", 10000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("JP1認定シニアコンサルタント", "日立製作所", "システム管理", 10000, "http://www.hitachi.co.jp/Prod/comp/soft1/cert/index_top.html", "JP1"),
            new CertificationEntity("CGクリエイター検定 ベーシック", "CG-ARTS協会", "Webデザイン", 4700, "http://www.cgarts.or.jp/kentei/", "Webデザイン"),
            new CertificationEntity("CGクリエイター検定 エキスパート", "CG-ARTS協会", "Webデザイン", 5700, "http://www.cgarts.or.jp/kentei/", "Webデザイン"),
            new CertificationEntity("CGエンジニア検定 ベーシック", "CG-ARTS協会", "Webデザイン", 4700, "http://www.cgarts.or.jp/kentei/", "Webデザイン"),
            new CertificationEntity("CGエンジニア検定 エキスパート", "CG-ARTS協会", "Webデザイン", 5700, "http://www.cgarts.or.jp/kentei/", "Webデザイン"),
            new CertificationEntity("Webデザイナー検定 ベーシック", "CG-ARTS協会", "Webデザイン", 4700, "http://www.cgarts.or.jp/kentei/", "Webデザイン"),
            new CertificationEntity("Webデザイナー検定 エキスパート", "CG-ARTS協会", "Webデザイン", 5700, "http://www.cgarts.or.jp/kentei/", "Webデザイン"),
            new CertificationEntity("画像処理エンジニア検定 ベーシック", "CG-ARTS協会", "Webデザイン", 4700, "http://www.cgarts.or.jp/kentei/", "Webデザイン"),
            new CertificationEntity("画像処理エンジニア検定 エキスパート", "CG-ARTS協会", "Webデザイン", 5700, "http://www.cgarts.or.jp/kentei/", "Webデザイン"),
            new CertificationEntity("マルチメディア検定 CGクリエイター検定 ベーシック", "CG-ARTS協会", "Webデザイン", 4700, "http://www.cgarts.or.jp/kentei/", "Webデザイン"),
            new CertificationEntity("マルチメディア検定 CGクリエイター検定 エキスパート", "CG-ARTS協会", "Webデザイン", 5700, "http://www.cgarts.or.jp/kentei/", "Webデザイン"),
            new CertificationEntity("Webリテラシー試験", "ワークスコーポレーション", "一般", 16000, "http://www.webken.jp/", ""),
            new CertificationEntity("Webデザイナー試験", "ワークスコーポレーション", "一般", 16000, "http://www.webken.jp/", ""),
            new CertificationEntity("Webディレクター試験", "ワークスコーポレーション", "一般", 16000, "http://www.webken.jp/", ""),
            new CertificationEntity("Webプロデューサー試験", "ワークスコーポレーション", "一般", 16000, "http://www.webken.jp/", ""),
            new CertificationEntity("ウェブデザイン技能検定 3級", "インターネットスキル認定普及協会", "Webデザイン", 10000, "http://www.webdesign.gr.jp/", ""),
            new CertificationEntity("ウェブデザイン技能検定 2級", "インターネットスキル認定普及協会", "Webデザイン", 18500, "http://www.webdesign.gr.jp/", ""),
            new CertificationEntity("ウェブデザイン技能検定 1級", "インターネットスキル認定普及協会", "Webデザイン", 32000, "http://www.webdesign.gr.jp/", ""),
            new CertificationEntity("情報セキュリティ管理士認定試験", "全日本情報学習振興協会", "セキュリティ", 10000, "http://www.joho-gakushu.or.jp/", ""),
            new CertificationEntity("情報セキュリティ初級認定試験", "全日本情報学習振興協会", "セキュリティ", 8000, "http://www.joho-gakushu.or.jp/", ""),
            new CertificationEntity("UMLモデリング技能認定試験 L0", "UMTP", "UML", 0, "http://www.umtp-japan.org/", ""),
            new CertificationEntity("UMLモデリング技能認定試験 L1", "UMTP", "UML", 0, "http://www.umtp-japan.org/", ""),
            new CertificationEntity("UMLモデリング技能認定試験 L2", "UMTP", "UML", 0, "http://www.umtp-japan.org/", ""),
            new CertificationEntity("UMLモデリング技能認定試験 L3", "UMTP", "UML", 0, "http://www.umtp-japan.org/", ""),
            new CertificationEntity("UMLモデリング技能認定試験 L4", "UMTP", "UML", 0, "http://www.umtp-japan.org/", ""),
            new CertificationEntity("Excel VBA ベーシック", "Odyssey", "プログラミング", 12000, "http://vbae.odyssey-com.co.jp/", "Excel / VBA"),
            new CertificationEntity("Excel VBA スタンダード", "Odyssey", "プログラミング", 13500, "http://vbae.odyssey-com.co.jp/", "Excel / VBA"),
            new CertificationEntity("Access VBA ベーシック", "Odyssey", "プログラミング", 12000, "http://vbae.odyssey-com.co.jp/", "Access / VBA"),
            new CertificationEntity("Access VBA スタンダード", "Odyssey", "プログラミング", 13500, "http://vbae.odyssey-com.co.jp/", "Access / VBA"),
            new CertificationEntity("AWS 認定ソリューションアーキテクト – アソシエイトレベル", "Amazon", "サーバー", 15000, "http://aws.amazon.com/jp/certification/", "AWS / DevOps / Cloud"),
            new CertificationEntity("AWS 認定ソリューションアーキテクト – プロフェッショナルレベル", "Amazon", "サーバー", 30000, "http://aws.amazon.com/jp/certification/", "AWS / DevOps / Cloud"),
            new CertificationEntity("AWS 認定デベロッパー – アソシエイトレベル", "Amazon", "サーバー", 15000, "http://aws.amazon.com/jp/certification/", "AWS / DevOps / Cloud"),
            new CertificationEntity("AWS 認定システムオペレーション（SysOps）アドミニストレーター – アソシエイトレベル", "Amazon", "サーバー", 15000, "http://aws.amazon.com/jp/certification/", "AWS / DevOps / Cloud"),
            new CertificationEntity("検索技術者検定 3級", "情報科学技術協会", "一般", 4000, "http://www.infosta.or.jp/examination/", ""),
            new CertificationEntity("検索技術者検定 2級", "情報科学技術協会", "一般", 6000, "http://www.infosta.or.jp/examination/", ""),
            new CertificationEntity("検索技術者検定 1級", "情報科学技術協会", "一般", 10000, "http://www.infosta.or.jp/examination/", ""),
            new CertificationEntity("パソコン整備士検定 3級", "パソコン整備士協会", "一般", 10000, "http://www.pc-seibishi.org/", ""),
            new CertificationEntity("パソコン整備士検定 2級", "パソコン整備士協会", "一般", 10000, "http://www.pc-seibishi.org/", ""),
            new CertificationEntity("パソコン整備士検定 1級", "パソコン整備士協会", "一般", 10000, "http://www.pc-seibishi.org/", ""),
            new CertificationEntity("Cisco Certified Entry Networking Technician", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Technician", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Associate Routing and Switching", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Design Associate", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Associate Data Center", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Associate Security", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Associate Service Provider", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Associate Service Provider Operations", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Associate Video", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Associate Voice", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Associate Wireless", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Design Professional", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Professional Routing and Switching", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Professional Routing and Switching", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Professional Data Center", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Professional Security", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Professional Service Provider", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Professional Service Provider Operations", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Professional Voice", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Network Professional Wireless", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Design Expert", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Internetwork Expert Collaboration", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Internetwork Expert Data Center", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Internetwork Expert Routing and Switching", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Internetwork Expert Security", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Internetwork Expert Service Provider", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Internetwork Expert Service Provider Operations", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Internetwork Expert Wireless", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("Cisco Certified Architect", "Cisco", "ネットワーク", 0, "http://www.cisco.com/web/JP/learning/certifications/index.html", "ネットワーク"),
            new CertificationEntity("ORACLE MASTER Bronze Oracle Database 12c", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("ORACLE MASTER Silver Oracle Database 12c", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("ORACLE MASTER Gold Oracle Database 12c ", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Database 12c Certified Implementation Specialist", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Database Performance and Tuning 2015 Certified Implementation Specialist", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("ORACLE MASTER Bronze Oracle Database 11g", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("ORACLE MASTER Silver Oracle Database 11g ", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("ORACLE MASTER Gold Oracle Database 11g ", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("ORACLE MASTER Platinum Oracle Database 11g", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Database 11g Certified Implementation Specialist", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Real Application Clusters 11g Certified Implementation Specialist", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Database 11g Security Certified Implementation Specialist", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Database 11g Data Warehousing Certified Implementation Specialist", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Database 11g Performance Tuning Certified Expert", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Certified Expert, Oracle Real Application Clusters 11g and Grid Infrastructure Administrator", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("ORACLE MASTER Bronze Oracle Database 10g", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("ORACLE MASTER Silver Oracle Database 10g ", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("ORACLE MASTER Gold Oracle Database 10g ", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("ORACLE MASTER Platinum Oracle Database 10g", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Database 10g: Managing Oracle on Linux Certified Expert", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Database 10g: Real Application Clusters Administrator Certified Expert", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Spatial 11g Certified Implementation Specialist", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Database 9i Administrator Certified Professional", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Database 9i Administrator Certified Professional", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Certified Professional, Database Cloud Administrator", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Certified Master, Database Cloud Administrator", "Oracle", "データベース", 0, "http://www.oracle.com/jp/education/certification", "データベース"),
            new CertificationEntity("Oracle Certified Java Programmer, Bronze SE 7", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle Certified Java Programmer, Silver SE 7", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle認定Javaアソシエイツ", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle Certified Java Programmer, Gold SE 7", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle認定JavaプログラマSE 5", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle認定JavaプログラマSE 6", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle認定JavaディベロッパSE 6", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle認定WebコンポーネントディベロッパEE 5", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle認定ビジネスコンポーネントディベロッパEE 5", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle認定Java WebサービスディベロッパEE 5", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle認定エンタープライズアーキテクトEE 5", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle Certified Master, Java EE 6 Enterprise Architect", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle Certified Expert, Java EE 6 Java Persistence API Developer", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle Certified Expert, EE 6 Enterprise JavaBeans Developer", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle Certified Expert, Java EE 6 Web Services Developer", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle Certified Expert, Java EE 6 JavaServer Faces Developer", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle Certified Expert, Java EE 6 Web Component Developer", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle認定モバイルアプリケーションディベロッパ", "Oracle", "プログラミング", 0, "http://www.oracle.com/jp/education/certification", "Java"),
            new CertificationEntity("Oracle Certified Associate, Oracle Linux 5 and 6 System Administrator", "Oracle", "サーバー", 0, "http://www.oracle.com/jp/education/certification", "Linux"),
            new CertificationEntity("Oracle Certified Professional, Oracle Linux 6 System Administrator", "Oracle", "サーバー", 0, "http://www.oracle.com/jp/education/certification", "Linux"),
            new CertificationEntity("Oracle Linux Certified Implementation Specialist", "Oracle", "サーバー", 0, "http://www.oracle.com/jp/education/certification", "Linux"),
            new CertificationEntity("Oracle Linux 6 Certified Implementation Specialist", "Oracle", "サーバー", 0, "http://www.oracle.com/jp/education/certification", "Linux"),
            new CertificationEntity("Oracle Certified Associate, Oracle Solaris 11 System Administrator", "Oracle", "サーバー", 0, "http://www.oracle.com/jp/education/certification", "Solaris"),
            new CertificationEntity("Oracle Certified Professional, Oracle Solaris 11 System Administrator", "Oracle", "サーバー", 0, "http://www.oracle.com/jp/education/certification", "Solaris"),
            new CertificationEntity("Oracle Solaris 11 Installation and Configuration Certified Implementation Specialist", "Oracle", "サーバー", 0, "http://www.oracle.com/jp/education/certification", "Solaris"),
            new CertificationEntity("Oracle認定Oracle Solaris 10 アソシエイツ", "Oracle", "サーバー", 0, "http://www.oracle.com/jp/education/certification", "Solaris"),
            new CertificationEntity("Oracle認定Oracle Solaris 10 システム管理者", "Oracle", "サーバー", 0, "http://www.oracle.com/jp/education/certification", "Solaris"),
            new CertificationEntity("Oracle Certified Professional, Oracle Solaris Cluster 3.2 System Administrator", "Oracle", "サーバー", 0, "http://www.oracle.com/jp/education/certification", "Solaris"),
            new CertificationEntity("Oracle認定Oracle Solaris 10 ネットワーク管理者", "Oracle", "サーバー", 0, "http://www.oracle.com/jp/education/certification", "Solaris"),
            new CertificationEntity("Oracle認定Oracle Solaris 10 セキュリティ管理者", "Oracle", "サーバー", 0, "http://www.oracle.com/jp/education/certification", "Solaris")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // リリース用キャプチャ取得用
        // ステータスバー非表示
//        getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // リストする資格をセットする
        ArrayList<CertificationEntity> cEntities = new ArrayList<CertificationEntity>();

        Integer i = 1;
        for(CertificationEntity cEntity: cList) {
            cEntity.setId(i++);
            cEntities.add(cEntity);
        }

        Callback callback = new Callback() {
            @Override
            public void onSuccessInit() {

                TextView cCounter = (TextView)findViewById(R.id.cCounter);
                cCounter.setText("全" + cList.size() + "資格掲載");

                Button btn2 = (Button)findViewById(R.id.button2);
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, ListSectionByOrganizationNameActivity.class);
                        startActivity(intent);
                    }
                });

                Button btn3 = (Button)findViewById(R.id.button3);
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, ListSectionByPrimaryCategoryActivity.class);
                        startActivity(intent);
                    }
                });

                Button bByPrice = (Button)findViewById(R.id.b_by_price);
                bByPrice.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, ListSectionByPriceActivity.class);
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onFailedInit() {
            }
        };

        SkeletonAsync async = new SkeletonAsync(MainActivity.this,cEntities,callback);
        async.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
